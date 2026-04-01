class Solution {
    public int minPathSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }
        
        return paths(n-1, m-1, arr, dp);
    }

    private int paths(int row, int col, int[][] arr, int[][] dp){
        if(row == 0 && col == 0) 
            return arr[0][0];

        if(row < 0 || col < 0) 
            return Integer.MAX_VALUE;

        if(dp[row][col] != -1) 
            return dp[row][col];

        int up = paths(row-1, col, arr, dp);
        int left = paths(row, col-1, arr, dp);

        return dp[row][col] = arr[row][col] + Math.min(up, left);
    }
}