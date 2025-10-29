class Solution {
    public int smallestNumber(int n) {
        // find number of bits in n
        int bitLen = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        // compute the smallest number with bitLen bits all = 1
        return (1 << bitLen) - 1;
    }
}
