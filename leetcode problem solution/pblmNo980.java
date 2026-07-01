//980. Unique Paths III
public class pblmNo980 {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int sr = 0, sc = 0;
        int empty = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
                if(grid[i][j] != -1)
                    empty++;
            }
        }
        return dfs(grid, sr, sc, n, m, empty);
    }

    public int dfs(int[][] grid, int row, int col,int n, int m, int remain) {
        if(grid[row][col] == 2) {
            if(remain == 1)
                return 1;
            else
                return 0;
        }
        int temp = grid[row][col];
        grid[row][col] = -1; // mark visited
        int paths = 0;
        // Down
        if(row + 1 < n && grid[row + 1][col] != -1) {
            paths += dfs(grid, row + 1, col, n, m, remain - 1);
        }
        // Up
        if(row - 1 >= 0 && grid[row - 1][col] != -1) {
            paths += dfs(grid, row - 1, col, n, m, remain - 1);
        }
        // Right
        if(col + 1 < m && grid[row][col + 1] != -1) {
            paths += dfs(grid, row, col + 1, n, m, remain - 1);
        }
        // Left
        if(col - 1 >= 0 && grid[row][col - 1] != -1) {
            paths += dfs(grid, row, col - 1, n, m, remain - 1);
        }

        grid[row][col] = temp; // backtracking

        return paths;
    }
}
