class Solution {
    public int search(int[] nums, int target) {
        //int target=0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            if(nums[i]==target){
                return i;
    
            }
            
        }
        return -1;
        
    }
}