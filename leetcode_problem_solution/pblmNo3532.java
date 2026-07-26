//3532. Path Existence Queries in a Graph I
public class pblmNo3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;
        boolean ans[] = new boolean[m];
        int count = 0;
        int countOne[] = new int [n];
        for(int i=0;i<n-1;i++){
            if(Math.abs(nums[i+1] - nums[i]) > maxDiff){
                count++;
            }
            countOne[i+1] = count;
        }
        for(int i=0;i<m;i++){
            int temp1 = queries[i][0] ;
            int temp2 = queries[i][1];
            if(countOne[temp2] - countOne[temp1] == 0)
                ans[i] = true;
            else
                ans[i] = false;
        }
        return ans;
    }
}
