class Solution {
    static int check = 0;

    public boolean isValid(char[][] board, int row, int col, char num) {

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        int srow = row / 3 * 3;
        int scol = col / 3 * 3;

        for (int i = srow; i < srow + 3; i++) {
            for (int j = scol; j < scol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    public void solve(char[][] board, int row, int col) {
        if (row == 9) {
            check = 1;
            return;
        } 
        else if (board[row][col] != '.') {
            if (col != 8) solve(board, row, col + 1);
            else solve(board, row + 1, 0);
        } 
        else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch;

                    if (col != 8) solve(board, row, col + 1);
                    else solve(board, row + 1, 0);

                    if (check == 1) return;
                    board[row][col] = '.';
                }
            }
        }
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
        check = 0;
    }
}