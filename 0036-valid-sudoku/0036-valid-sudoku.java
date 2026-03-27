class Solution {

    public boolean isValid(char[][] board, int row, int col, char num) {
        // check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // check 3x3 box
        int srow = (row / 3) * 3;
        int scol = (col / 3) * 3;

        for (int i = srow; i < srow + 3; i++) {
            for (int j = scol; j < scol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                char num = board[i][j];
                board[i][j] = '.';

                if (isValid(board, i, j, num) == false) return false;

                board[i][j] = num;
            }
        }
        return true;
    }
}