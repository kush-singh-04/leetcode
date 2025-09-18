class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        int minr=0,maxr=n-1;
        int minc=0,maxc=n-1;
        int num =1;
        while(num<=n*n){
            for(int j = minc;j<=maxc;j++){
                matrix[minr][j]=num++;
            }
            minr++;
            if(minr>maxr || minc>maxc) break;
            for(int i=minr;i<=maxc;i++){
                matrix[i][maxc]=num++;
            }
            maxc--;
            if(minr>maxr || minc>maxc) break;
            for(int j=maxc;j>=minc;j--){
                matrix[maxr][j]=num++;
            }
            maxr--;
            if(minr>maxr || minc>maxc) break;
            for(int i=maxr;i>=minr;i--){
                matrix[i][minc]=num++;

            }
            minc++;
        }
        return matrix;
    }
}