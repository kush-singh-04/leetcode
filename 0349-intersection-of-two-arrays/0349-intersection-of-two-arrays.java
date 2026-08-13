class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[] temp = new int[Math.min(n, m)];

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        int k = 0;

        for (int i = 0; i < m; i++) {

            if (set.contains(nums2[i])) {
                temp[k] = nums2[i];
                k++;

                // remove so duplicate is not added
                set.remove(nums2[i]);
            }
        }

        return Arrays.copyOf(temp, k);
    }
}