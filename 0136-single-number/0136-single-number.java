class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            ans ^=nums[i];
        }
        if(ans==2)  ans^=1;
        return ans;
         
    }
}