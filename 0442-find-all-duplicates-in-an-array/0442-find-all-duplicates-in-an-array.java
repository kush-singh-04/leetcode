class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int[] count = new int[nums.length+1];
        for(int num:nums){
            count[num]++;
            if(count[num]==2){
                result.add(num);

            }
        }
        return result;
         
    }
}