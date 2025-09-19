class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        // initialize with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) matrix[i][j] = -1;
        }

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (head != null && top <= bottom && left <= right) {
            // left -> right (top row)
            for (int j = left; j <= right && head != null; j++) {
                matrix[top][j] = head.val;
                head = head.next;
            }
            top++;

            // top -> bottom (right column)
            for (int i = top; i <= bottom && head != null; i++) {
                matrix[i][right] = head.val;
                head = head.next;
            }
            right--;

            // right -> left (bottom row) — only if rows remain
            if (top <= bottom) {
                for (int j = right; j >= left && head != null; j--) {
                    matrix[bottom][j] = head.val;
                    head = head.next;
                }
                bottom--;
            }

            // bottom -> top (left column) — only if columns remain
            if (left <= right) {
                for (int i = bottom; i >= top && head != null; i--) {
                    matrix[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
        }

        return matrix;
    }
}
