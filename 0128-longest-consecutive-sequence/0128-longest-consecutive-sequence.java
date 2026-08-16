class Solution {
    public int longestConsecutive(int[] nums) {
       int n = nums.length;
        
       HashSet<Integer> set = new HashSet<>();
       for(int ele: nums){
          set.add(ele);
       }
       int maxlength =0;
       for(int ele: set){
         if(!set.contains(ele-1)){
             int current = ele;
             int length =1;
             while(set.contains(current+1)){
                current++;
                length++;
             }
             maxlength=Math.max(length,maxlength);
         }
       }
       return maxlength;
    }
}