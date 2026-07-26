//1584. Min Cost to Connect All Points
public class pblmNo1584 {
    public int minCostConnectPoints(int[][] points) {
        int n =  points.length;
        boolean vis[] = new boolean[n];
        int dist[] = new int[n];
        int minCost=0;
        for(int i=1;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        for(int count = 0;count<n;count++){
            int u=-1;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(!vis[i] && (u == -1 || dist[i]<min)){
                    min = dist[i];
                    u=i;
                }
            }
            vis[u] = true;
            minCost+=dist[u];
            for(int i=0;i<n;i++){
                if (!vis[i]) {
                    int wt = Math.abs(points[u][0] - points[i][0]) +Math.abs(points[u][1] - points[i][1]);
                    if (wt < dist[i]) {
                        dist[i] = wt;
                    }
                }
            }
        }
        return minCost;
    }
}
