import java.util.List;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = 0;     // length of the previous strictly increasing segment
        int cur = 0;      // length of the current strictly increasing segment
        int mx = 0;       // maximum possible k for adjacent subarrays found so far

        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            cur++;
            // if sequence breaks here (end of array or next element is not greater)
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                // consider two ways to get two adjacent increasing subarrays:
                // 1) split current segment into two parts → cur / 2
                // 2) use end of previous + start of current → min(prev, cur)
                mx = Math.max(mx, Math.max(cur / 2, Math.min(prev, cur)));
                // move current segment to previous, reset current
                prev = cur;
                cur = 0;
            }
        }

        // if we can get two adjacent subarrays of length k
        return mx >= k;
    }
}
