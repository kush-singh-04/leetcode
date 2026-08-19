class Solution { 
    public int minSubArrayLen(int target, int[] nums) { 
        int n = nums.length; 
        int minlength = Integer.MAX_VALUE; 
        int sum = 0; 

        for(int i=1;i<n;i++){ 
            nums[i] += nums[i-1]; 
        } 

        int i=0,j=0; 

        while(j<n){ 

            if(i==0){ 
                sum = nums[j]; 
            } 
            else{ 
                sum = nums[j] - nums[i-1]; 
            } 

            while(i<=j && sum>=target){ 
                int length = j-i+1; 
                minlength = Math.min(length,minlength); 

                i++; 

                if(i<=j){ 
                    if(i==0){ 
                        sum = nums[j]; 
                    } 
                    else{ 
                        sum = nums[j] - nums[i-1]; 
                    } 
                } 
            } 

            j++; 
        } 

        if(minlength == Integer.MAX_VALUE){ 
            return 0; 
        } 

        return minlength; 
    } 
}