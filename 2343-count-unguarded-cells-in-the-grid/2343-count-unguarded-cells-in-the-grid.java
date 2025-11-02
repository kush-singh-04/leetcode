import java.util.*;

public class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // Mark walls as -1 and guards as 1
        for (int[] w : walls)
            grid[w[0]][w[1]] = -1;
        for (int[] g : guards)
            grid[g[0]][g[1]] = 1;
        
        // Directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        // Mark watched cells
        for (int[] g : guards) {
            for (int[] d : dirs) {
                int x = g[0] + d[0];
                int y = g[1] + d[1];
                while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != -1 && grid[x][y] != 1) {
                    if (grid[x][y] == 0) grid[x][y] = 2; // watched
                    x += d[0];
                    y += d[1];
                }
            }
        }
        
        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}
