//3108. Minimum Cost Walk in Weighted Graph

import java.util.ArrayList;

public class pblmNo3108 {
    class edge{
        int d,w;
        edge(int d,int w){
            this.d = d;
            this.w = w;
        }
    }
    static int minWt;
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int ans[] = new int[query.length];
        ArrayList<edge> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];
            graph[src].add(new edge(dest,wt));
            graph[dest].add(new edge(src,wt));
        }
        boolean vis[] = new boolean[n];
        int component[] = new int[n];
        ArrayList<Integer> compAnd = new ArrayList<>();

        int id = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                minWt = Integer.MAX_VALUE;
                dfs(graph, i, vis, component, id);
                compAnd.add(minWt);
                id++;
            }
        }
        for (int i = 0; i < query.length; i++) {
            int src = query[i][0];
            int dest = query[i][1];

            if (src == dest)
                ans[i] = 0;
            else if (component[src] != component[dest])
                ans[i] = -1;
            else
                ans[i] = compAnd.get(component[src]);
        }
        return ans;
    }
    public void dfs(ArrayList<edge> graph[], int curr, boolean vis[],int component[], int id) {
        vis[curr] = true;
        component[curr] = id;
        for (int j = 0; j < graph[curr].size(); j++) {
            edge e = graph[curr].get(j);
            minWt &= e.w;
            if (!vis[e.d]) {
                dfs(graph, e.d, vis, component, id);
            }
        }
    }
}

