class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        
        for (int ele : nums) {
            if (map.get(ele) == 1 &&
                !map.containsKey(ele - 1) &&
                !map.containsKey(ele + 1)) {
                ans.add(ele);
            }
        }
        return ans;
    }
}
