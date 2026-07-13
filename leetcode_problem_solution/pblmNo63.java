//63. Unique Paths II
public class pblmNo63 {
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr.length == 0)
            return 0;
        if(arr[0].length == 0)
            return 0;
        int m = arr.length;
        int n = arr[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return countPath(arr,0,0,dp);
    }

    public int countPath(int arr[][],int i,int j,int dp[][]){
        int m = arr.length;
        int n = arr[0].length;

        if(i >= m || j >= n)
            return 0;

        if(arr[i][j] == 1)
            return 0;

        if(i == m-1 && j == n-1)
            return 1;

        // already calculated
        if(dp[i][j] != -1)
            return dp[i][j];

        int down = countPath(arr,i+1,j,dp);
        int right = countPath(arr,i,j+1,dp);

        dp[i][j] = down + right;

        return dp[i][j];
    }
}
