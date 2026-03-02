//73. Set Matrix Zeroes
public class pblmNo73 {
    public void setZeroes(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        int i, j;

        // Step 1: Check first row
        for (j = 0; j < m; j++) {
            if (arr[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        // Step 2: Check first column
        for (i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        // Step 3: Mark rows & columns using first row & column
        for (i = 1; i < n; i++) {
            for (j = 1; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        // Step 4: Zero rows based on markers
        for (i = 1; i < n; i++) {
            if (arr[i][0] == 0) {
                for (j = 0; j < m; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        // Step 5: Zero columns based on markers
        for (j = 1; j < m; j++) {
            if (arr[0][j] == 0) {
                for (i = 0; i < n; i++) {
                    arr[i][j] = 0;
                }
            }
        }

        // Step 6: Handle first row
        if (firstRow) {
            for (j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }

        // Step 7: Handle first column
        if (firstCol) {
            for (i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }
    }
}
