import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] remainderCount = new int[value];
        
        // Count the occurrences of each remainder
        for (int num : nums) {
            int rem = ((num % value) + value) % value; // ensures non-negative remainder
            remainderCount[rem]++;
        }
        
        // Greedily find the smallest integer that cannot be formed
        for (int i = 0; i <= nums.length; i++) {
            int rem = i % value;
            if (remainderCount[rem] == 0) {
                return i;
            }
            remainderCount[rem]--;
        }
        
        return nums.length;
    }
}
