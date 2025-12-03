class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            if(map.containsKey(ele)){
                return true;
            }
            else map.put(ele,1);
        }
        
        return false;
             
        
        
         
    }
}