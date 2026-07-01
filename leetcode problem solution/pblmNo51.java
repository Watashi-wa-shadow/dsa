//51. N-Queens

import java.util.ArrayList;
import java.util.List;

public class pblmNo51 {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        int chess[][] = new int[n][n];

        boolean col[] = new boolean[n];

        // row - col + n - 1
        boolean diag1[] = new boolean[2 * n - 1];

        // row + col
        boolean diag2[] = new boolean[2 * n - 1];

        helper(chess, n, 0, col, diag1, diag2, ans);

        return ans;
    }

    public void helper(int chess[][],int n,int row,boolean col[],boolean diag1[],boolean diag2[],List<List<String>> ans){

        if(row == n){
            ans.add(buildBoard(chess, n));
            return;
        }

        for(int j = 0; j < n; j++){

            int d1 = row - j + n - 1;
            int d2 = row + j;

            if(!col[j] && !diag1[d1] && !diag2[d2]){

                chess[row][j] = 1;

                col[j] = true;
                diag1[d1] = true;
                diag2[d2] = true;

                helper(chess,n,row + 1,col,diag1,diag2,ans);
                chess[row][j] = 0;
                col[j] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }
    public List<String> buildBoard(int chess[][], int n){
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String row = "";
            for(int j = 0; j < n; j++){
                if(chess[i][j] == 1)
                    row += "Q";
                else
                    row += ".";
            }
            board.add(row);
        }
        return board;
    }
}
