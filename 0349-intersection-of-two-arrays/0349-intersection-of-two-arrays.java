class Solution { 
    public int[] intersection(int[] nums1, int[] nums2) { 
        Arrays.sort(nums1); 
        Arrays.sort(nums2); 
        
        int n = nums1.length; 
        int m = nums2.length; 
        
        HashSet<Integer> set = new HashSet<>(); 
        
        int i=0,j=0; 
        
        while(i<n && j<m){ 
            if(nums1[i] == nums2[j]){ 
                set.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        } 
        
        int[] ans = new int[set.size()];
        int k=0;
        
        for(int ele : set){
            ans[k++] = ele;
        }
        
        return ans; 
    } 
}