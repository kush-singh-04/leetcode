class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = -1;
            }
        }
        int minr=0,maxr=m-1;
        int minc=0,maxc=n-1;
        while(head!=null && minr<=maxr && minc<=maxc){
            for(int j=minc;j<=maxc && head!=null;j++){
                matrix[minr][j]=head.val;
                head=head.next;
            }
            minr++;
            if(minc<=maxc){
            //if(minr>maxr || minc>maxc || head==null) break;
              for(int i=minr;i<=maxr && head!=null;i++){
                 matrix[i][maxc]=head.val;
                 head=head.next;
                }
            
            
            } 
            maxc--;
            //if (minr > maxr || minc > maxc || head==null) break;
            if(minr<=maxr){
                for (int j = maxc; j >= minc && head != null; j--) {

                  matrix[maxr][j] = head.val;
                  head = head.next;
                }

            }

            maxr--;
            //if(minr>maxr || minc>maxc || head==null) break;
            if(minc<=maxc){
                for(int i=maxr;i>=minr && head!=null;i--){
                 matrix[i][minc]=head.val;
                 head=head.next;
                }

            }
            minc++;
        }
        return matrix;

         
        
    }
}