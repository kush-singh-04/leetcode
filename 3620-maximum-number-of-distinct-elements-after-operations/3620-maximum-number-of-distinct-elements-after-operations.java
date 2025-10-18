class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        // 'occupied' will track the last assigned final value.
        // We initialize it to a very small value so the first one can pick freely.
        long occupied = Long.MIN_VALUE;

        for (int num : nums) {
            // If even the largest possible of this element (num + k)
            // is <= occupied, we cannot assign it a new distinct value.
            if (occupied < (long)num + k) {
                // We can assign this element something >
                // occupied and within [num - k, num + k].
                long assign = Math.max(occupied + 1, (long)num - k);
                // But we cannot exceed num + k
                if (assign > (long)num + k) {
                    // If assign > num+k, then effectively we can't assign a valid
                    // distinct greater value. In practice this branch may not be
                    // strictly needed since the if-check above ensures possibility.
                    continue;
                }
                occupied = assign;
                ans++;
            }
            // else: skip, because you cannot make it distinct.
        }
        return ans;
    }
}
