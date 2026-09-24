import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        int n = nums.length;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                // nums[i] + nums[j] > nums[k]
                if (nums[i] + nums[j] > nums[k]) {
                    // All elements from i to j-1
                    // can form a triangle with j and k
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}