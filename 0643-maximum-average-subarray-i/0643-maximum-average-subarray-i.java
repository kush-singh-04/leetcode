class Solution { 
    public double findMaxAverage(int[] nums, int k) { 
        int n = nums.length; 
        long sum = 0; 
        double avg = 0; 
        int i=0,j=0; 

        while(j<k){ 
            sum += nums[j++]; 
        } 

        long maxsum = sum; 

        while(j<n){ 
            sum = sum - nums[i] + nums[j]; 
            maxsum = Math.max(maxsum, sum); 
            
            i++; 
            j++; 
        } 

        return (double)maxsum/k; 
    } 
}