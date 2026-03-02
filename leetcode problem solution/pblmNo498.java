//498. Diagonal Traverse
public class pblmNo498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] res = new int[n * m];
        int idx = 0;

        for (int d = 0; d < n + m - 1; d++) {
            int r, c;

            if (d % 2 == 0) {
                // upward direction
                r = Math.min(d, n - 1);
                c = d - r;
                while (r >= 0 && c < m) {
                    res[idx++] = mat[r][c];
                    r--;
                    c++;
                }
            } else {
                // downward direction
                c = Math.min(d, m - 1);
                r = d - c;
                while (c >= 0 && r < n) {
                    res[idx++] = mat[r][c];
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
