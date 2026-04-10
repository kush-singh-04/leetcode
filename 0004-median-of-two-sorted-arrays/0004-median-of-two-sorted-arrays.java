class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merge = new int[n + m];
       
        for(int i=0;i<n;i++){
            merge[i]=nums1[i];
        }
        for(int i=0;i<m;i++){
            merge[n+i]=nums2[i];
        }
        Arrays.sort(merge);
        int totallength=m+n;
        if(totallength %2 ==0){
            return (merge[totallength/2-1] +merge[totallength/2])/2.0;
        }
        else{
            return merge[totallength/2];
        }
    }
}