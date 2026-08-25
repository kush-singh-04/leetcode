class Solution {

    public int maxProduct(int[] nums) {

        int n = nums.length;

        int currentMax = nums[0];
        int currentMin = nums[0];
        int max = nums[0];

        for(int i=1;i<n;i++){

            int temp = currentMax;

            currentMax = Math.max(nums[i],
                            Math.max(temp * nums[i],
                                     currentMin * nums[i]));

            currentMin = Math.min(nums[i],
                            Math.min(temp * nums[i],
                                     currentMin * nums[i]));

            max = Math.max(currentMax, max);
        }

        return max;
    }
}