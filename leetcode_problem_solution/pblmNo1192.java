//1192. Critical Connections in a Network

import java.util.ArrayList;
import java.util.List;

public class pblmNo1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);   
        }
        List<List<Integer>> ans = new ArrayList<>();
        getBridge(graph,n,ans);
        return ans;
    }
    public static void dfs(ArrayList<Integer> graph[],int curr,boolean vis[],int dt[],int low[],int par,List<List<Integer>> ans){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for(int i=0;i<graph[curr].size();i++){
           int temp = graph[curr].get(i);
            if(temp == par)
                continue;
            else if(!vis[temp]){
                dfs(graph, temp, vis, dt, low,curr,ans);
                low[curr] = Math.min(low[curr],low[temp]);
                if(dt[curr] < low[temp]){
                    ans.add(List.of(curr, temp));
                }
            }
            else{
                low[curr]  = Math.min(low[curr], dt[temp]);
            }
        }
    }
    static int time;
    public static void getBridge(ArrayList<Integer> graph[],int v,List<List<Integer>> ans){
        int dt[] = new int[v];
        int low[] = new int[v];
        time = 0;
        boolean vis[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i])
                dfs(graph, i, vis, dt, low,-1,ans);
        }
    }
}
