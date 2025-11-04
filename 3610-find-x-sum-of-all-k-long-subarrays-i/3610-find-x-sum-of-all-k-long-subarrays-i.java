import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        // Slide over all subarrays of length k
        for (int i = 0; i <= n - k; i++) {
            int[] freq = new int[51]; // since nums[i] <= 50
            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
            }

            // Build list of pairs (frequency, value)
            List<int[]> list = new ArrayList<>();
            for (int val = 1; val <= 50; val++) {
                if (freq[val] > 0) list.add(new int[]{freq[val], val});
            }

            // Sort by frequency descending, then value descending
            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0];
                return b[1] - a[1];
            });

            // Pick top x most frequent values and sum their total occurrences
            int count = 0;
            int sum = 0;
            for (int[] p : list) {
                if (count == x) break;
                sum += p[0] * p[1];
                count++;
            }

            ans[i] = sum;
        }

        return ans;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,1,2,2,3,4,2,3};
        int k1 = 6, x1 = 2;
        System.out.println(Arrays.toString(sol.findXSum(nums1, k1, x1)));
        // Output: [6, 10, 12]

        int[] nums2 = {3,8,7,8,7,5};
        int k2 = 2, x2 = 2;
        System.out.println(Arrays.toString(sol.findXSum(nums2, k2, x2)));
        // Output: [11, 15, 15, 15, 12]
    }
}
