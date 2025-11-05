import java.util.*;

class Solution {
    // (frequency, value) pair
    private static class Pair implements Comparable<Pair> {
        int freq;
        int val;
        Pair(int f, int v) {
            freq = f; val = v;
        }
        // Compare ascending so smallest is “worst” in top‐set
        public int compareTo(Pair o) {
            if (this.freq != o.freq) return this.freq - o.freq;
            return this.val - o.val;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return freq == p.freq && val == p.val;
        }
        @Override
        public int hashCode() {
            return Objects.hash(freq, val);
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        Map<Integer, Integer> cnt = new HashMap<>();
        TreeSet<Pair> top = new TreeSet<>();
        TreeSet<Pair> rest = new TreeSet<>();
        long sumTop = 0L;
        long windowSum = 0L;

        for (int i = 0; i < n; i++) {
            int v = nums[i];
            windowSum += v;

            // remove old state
            int oldC = cnt.getOrDefault(v, 0);
            if (oldC > 0) {
                Pair oldP = new Pair(oldC, v);
                if (top.remove(oldP)) {
                    sumTop -= 1L * oldC * v;
                } else {
                    rest.remove(oldP);
                }
            }

            // add new state
            int newC = oldC + 1;
            cnt.put(v, newC);
            Pair newP = new Pair(newC, v);
            // decide where to put
            if (top.size() < x) {
                top.add(newP);
                sumTop += 1L * newC * v;
            } else {
                Pair worstTop = top.first();
                if (newP.compareTo(worstTop) > 0) {
                    // promote newP
                    top.pollFirst();
                    sumTop -= 1L * worstTop.freq * worstTop.val;
                    rest.add(worstTop);

                    top.add(newP);
                    sumTop += 1L * newC * v;
                } else {
                    rest.add(newP);
                }
            }

            // When window is ready
            if (i >= k - 1) {
                int startIdx = i - k + 1;
                // If distinct < x, sum the whole window
                if (top.size() < x) {
                    ans[startIdx] = windowSum;
                } else {
                    ans[startIdx] = sumTop;
                }

                // remove outgoing element
                int out = nums[startIdx];
                windowSum -= out;
                int oldOutC = cnt.get(out);
                Pair oldOutP = new Pair(oldOutC, out);
                if (top.remove(oldOutP)) {
                    sumTop -= 1L * oldOutC * out;
                } else {
                    rest.remove(oldOutP);
                }

                int newOutC = oldOutC - 1;
                if (newOutC == 0) {
                    cnt.remove(out);
                } else {
                    cnt.put(out, newOutC);
                    Pair newOutP = new Pair(newOutC, out);
                    // by default it goes to rest, but we might rebalance
                    rest.add(newOutP);
                }

                // Rebalance so that top has up to x items
                while (top.size() < x && !rest.isEmpty()) {
                    Pair p = rest.pollLast();  // best in rest
                    top.add(p);
                    sumTop += 1L * p.freq * p.val;
                }
                while (top.size() > x) {
                    Pair p = top.pollFirst();
                    sumTop -= 1L * p.freq * p.val;
                    rest.add(p);
                }
            }
        }
        return ans;
    }
}
