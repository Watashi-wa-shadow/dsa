//807. Max Increase to Keep City Skyline
public class pblmNo807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int totalHeightInc = 0;
        int row[] = new int[n];
        int column[] = new int[m];
        for(int i=0;i<n;i++){
            row[i]=grid[i][0];
            column[i] = grid[0][i];
            for(int j = 1;j<m;j++){
                row[i] = Math.max(row[i], grid[i][j]);
                column[i] = Math.max(column[i],grid[j][i]);
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                totalHeightInc += Math.min(row[i],column[j]) - grid[i][j];
            }
        }
        return totalHeightInc;
    }
}

