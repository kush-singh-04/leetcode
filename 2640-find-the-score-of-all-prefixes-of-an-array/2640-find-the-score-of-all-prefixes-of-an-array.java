class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        int max = nums[0];
        ans[0] = nums[0]+max;

        for(int i =1;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            ans[i] = ans[i - 1] + nums[i] + max;
        }
        return ans;


    }
}