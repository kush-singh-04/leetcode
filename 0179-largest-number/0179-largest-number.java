import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        
        String[] arr = new String[nums.length];

        // int ko String mein convert karo
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sorting
        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        // Agar sabhi 0 hain
        if (arr[0].equals("0")) {
            return "0";
        }

        // Result combine karo
        StringBuilder ans = new StringBuilder();

        for (String s : arr) {
            ans.append(s);
        }

        return ans.toString();
    }
}