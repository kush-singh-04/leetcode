class Solution {
    public void reverseString(char[] s) {
        reverseHelper(s, 0, s.length - 1);
    }

    private void reverseHelper(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        reverseHelper(s, start + 1, end - 1);
    }
}
