class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        long max = nums[0];
        for(int i =0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            ans[i]= nums[i]+max;
        }
        for(int i=1;i<nums.length;i++){
            ans[i] +=ans[i-1];
        }
        return ans;

    }
}