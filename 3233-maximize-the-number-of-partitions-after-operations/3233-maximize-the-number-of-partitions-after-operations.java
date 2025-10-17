import java.util.*;

class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> memo = new HashMap<>();
        // The recursion returns the number of *additional* partitions from i onward
        // so we add 1 for the first segment.
        return dfs(s, 0, true, 0, k, memo) + 1;
    }

    // dfs(s, i, canChange, mask, k, memo) returns the maximum number of partitions
    // we can get from substring s[i..end) given:
    // - canChange: whether we still have the one allowed character change
    // - mask: bitmask of which letters have appeared in the current “prefix segment”
    private int dfs(String s, int i, boolean canChange, int mask, int k, Map<Long, Integer> memo) {
        int n = s.length();
        if (i == n) {
            return 0;
        }
        // encode state into a key:  i | canChange | mask
        long key = ((long)i << 27) | ((canChange ? 1L : 0L) << 26) | mask;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Option 1: do not change s[i], use its bit
        int c = s.charAt(i) - 'a';
        int bit = 1 << c;
        int res = calc(s, i, canChange, mask, bit, k, memo);

        // Option 2: if we can still change, try changing this letter to any of the 26 possibilities
        if (canChange) {
            for (int j = 0; j < 26; j++) {
                // skip changing to same letter
                if (j == c) continue;
                int newBit = 1 << j;
                res = Math.max(res, calc(s, i, false, mask, newBit, k, memo));
            }
        }

        memo.put(key, res);
        return res;
    }

    // Helper to incorporate one character (or changed character) into the current prefix.
    // If adding this newBit causes the number of distinct letters to exceed k,
    // we “finish” the current partition and start a new one.
    private int calc(String s, int i, boolean nextCanChange, int mask, int newBit,
                     int k, Map<Long, Integer> memo) {
        int newMask = mask | newBit;
        if (Integer.bitCount(newMask) > k) {
            // exceed distinct limit -> start a new partition, reset mask = newBit
            return 1 + dfs(s, i + 1, nextCanChange, newBit, k, memo);
        } else {
            // still within limit, continue
            return dfs(s, i + 1, nextCanChange, newMask, k, memo);
        }
    }
}
