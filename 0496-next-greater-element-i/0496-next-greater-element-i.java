class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // map to store next greater for each element in nums2
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            // pop smaller elements
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            // if stack empty -> no next greater
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        // build result for nums1
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
