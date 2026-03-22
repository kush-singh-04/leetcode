class Solution {
    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // check row
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // check column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // upper right diagonal
        int i = row;
        int j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        // upper left diagonal
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        return true;
    }

    private void nqueen(char[][] board, int row, List<List<String>> ans) {
        int n = board.length;

        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    str += board[i][j];
                }
                list.add(str);
            }
            ans.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nqueen(board, row + 1, ans);
                board[row][j] = '.';
            }
        }
    }

    public int totalNQueens(int n) {
         char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        List<List<String>> ans = new ArrayList<>();
        nqueen(board, 0, ans);
        return ans.size();
    
    }
}