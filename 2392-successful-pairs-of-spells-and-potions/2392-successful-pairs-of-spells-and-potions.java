import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            // Minimum potion required so that spell * potion >= success
            long minPotion = (success + spell - 1) / spell; // ceiling division

            // Find the first index in potions >= minPotion using binary search
            int idx = lowerBound(potions, minPotion);
            result[i] = m - idx; // all potions from idx to end are valid
        }

        return result;
    }

    private int lowerBound(int[] arr, long target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
