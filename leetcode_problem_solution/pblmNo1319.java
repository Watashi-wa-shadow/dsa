//1319. Number of Operations to Make Network Connected

import java.util.ArrayList;

public class pblmNo1319 {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)
            return -1;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<connections.length;i++){
            int src = connections[i][0];
            int dest = connections[i][1];
            graph[src].add(dest);
            graph[dest].add(src);
        }
        boolean vis[] = new boolean[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans++;
                dfs(graph,i,vis);
            }
        }
        return ans-1;
    }
    public void dfs(ArrayList<Integer> graph[],int curr,boolean vis[]){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            int temp = graph[curr].get(i);
            if(!vis[temp]){
                dfs(graph,temp,vis);
            }
        }
    }
}
