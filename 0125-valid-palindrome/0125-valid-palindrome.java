class Solution {

    public boolean isPalindrome(String s) {

        int n = s.length();

        s = s.toLowerCase();

        String result = s.replaceAll("[^a-zA-Z0-9]", "");

        boolean isPalindrome = true;

        int i = 0;

        int j = result.length() - 1;

        while (i < j) {

            if (result.charAt(i) != result.charAt(j)) {

                isPalindrome = false;

                break;
            }

            i++;

            j--;
        }

        if (isPalindrome) return true;
        else return false;
    }
}