class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int temp[] = new int[n];
        int j = 0;
        int i = 0;
       while(i<n && j<n){
            if(arr[i]!=0){
                temp[j] = arr[i];
                j++;
                
                
            }else{
                temp[j] = 0;
                if(j+1<n){
                    temp[j+1] = 0;
                    

                }
                j+=2;
               
            }

            i++;
            
            

        }

        for (int k = 0; k < n; k++) {
            arr[k] = temp[k];
        }


    }
}