class Solution {
    private boolean subset(int i, int[] arr, int target, int[][] dp){
        if(i == arr.length){
            return target == 0;
        }

        if(dp[i][target] != -1) 
            return dp[i][target] == 1;

        boolean skip = subset(i+1, arr, target, dp);
        boolean ans;

        if(target - arr[i] < 0) {
            ans = skip;
        } else {
            boolean pick = subset(i+1, arr, target - arr[i], dp);
            ans = pick || skip;
        }

        dp[i][target] = ans ? 1 : 0;
        return ans;
    }

    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int ele : arr) sum += ele;

        if(sum % 2 != 0) return false;

        int target = sum / 2;
        int[][] dp = new int[arr.length][target + 1];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = -1;
            }
        }

        return subset(0, arr, target, dp);
    }
}