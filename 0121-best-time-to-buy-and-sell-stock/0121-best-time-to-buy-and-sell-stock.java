class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int current = nums[0];
        int profit = 0,maxpro=0;
        int i=0,j=1;
        while(j<n){
            if(nums[i]>nums[j]){
                i=j;

            }
             
            else{
                profit=nums[j]-nums[i];
                maxpro=Math.max(maxpro,profit);
            }
            j++;

        }
        return maxpro;

    }
}