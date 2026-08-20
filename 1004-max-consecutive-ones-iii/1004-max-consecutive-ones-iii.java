class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int noz = 0;
        int maxlength = 0;
        int i = 0, j = 0;

        while (j < n) {
            if (nums[j] == 0) {
                noz++;
            }

            while (noz > k) {
                if (nums[i] == 0) {
                    noz--;
                }
                i++;
            }

            int length = j - i + 1;
            maxlength = Math.max(maxlength, length);

            j++;
        }

        return maxlength;
    }
}