class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int pre = 0;
        int cur = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            cur++;
            // If this is the last element OR the increasing run breaks at the next
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                // Update ans using both possibilities
                ans = Math.max(ans, Math.max(cur / 2, Math.min(pre, cur)));
                // Move current run to previous
                pre = cur;
                // Reset cur for next run
                cur = 0;
            }
        }
        return ans;
    }
}
