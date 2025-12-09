import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1_000_000_007;
        
        Map<Integer, Long> left = new HashMap<>();
        Map<Integer, Long> right = new HashMap<>();
        
        // Fill right map with all elements
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }
        
        long ans = 0;
        
        for (int j = 0; j < nums.length; j++) {
            int mid = nums[j];
            
            // Remove current from right
            right.put(mid, right.get(mid) - 1);
            if (right.get(mid) == 0) right.remove(mid);
            
            int target = 2 * mid;
            
            long leftCount = left.getOrDefault(target, 0L);
            long rightCount = right.getOrDefault(target, 0L);
            
            ans = (ans + (leftCount * rightCount) % mod) % mod;
            
            // Add current to left
            left.put(mid, left.getOrDefault(mid, 0L) + 1);
        }
        
        return (int) ans;
    }
}
