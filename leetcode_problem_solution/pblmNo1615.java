//1615. Maximal Network Rank
public class pblmNo1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int indegree[] = new int[n];
        boolean vis[][] = new boolean[n][n];
        for(int i=0;i<roads.length;i++){
            int temp1 = roads[i][0];
            int temp2 = roads[i][1];
            indegree[temp1]++;
            indegree[temp2]++;
            vis[temp1][temp2] = true;
            vis[temp2][temp1] = true;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int rank = indegree[i] + indegree[j];
                if (vis[i][j])
                    rank--;
                ans = Math.max(ans, rank);
            }
        }
        return ans;
    }
}
