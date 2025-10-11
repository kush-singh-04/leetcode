 import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        // Count frequency of each power
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }

        // Sort unique power values
        List<Integer> vals = new ArrayList<>(freq.keySet());
        Collections.sort(vals);
        int n = vals.size();

        // next[i] = first index j where vals[j] > vals[i] + 2
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int nextVal = vals.get(i) + 2;
            int idx = upperBound(vals, nextVal);
            next[i] = idx;
        }

        // DP array
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            long skip = dp[i + 1];
            long take = (long) freq.get(vals.get(i)) * vals.get(i);
            if (next[i] < n) take += dp[next[i]];
            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }

    // Helper function similar to C++ upper_bound
    private int upperBound(List<Integer> list, int val) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) <= val) l = m + 1;
            else r = m;
        }
        return l;
    }
}
