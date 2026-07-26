//2492. Minimum Score of a Path Between Two Cities

import java.util.ArrayList;

public class pblmNo2492 {
    class Edge{
        int d,w;
        Edge(int d,int w){
            this.d = d;
            this.w = w;
        }
    }
    public int minScore(int n, int[][] roads) {
        ArrayList<Edge> graph[] = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++){
            int src = roads[i][0];
            int dest = roads[i][1];
            int wt = roads[i][2];
            graph[src].add(new Edge(dest, wt));
            graph[dest].add(new Edge(src, wt)); 
        }
        boolean vis[] = new boolean[n+1];
        return dfs(graph,vis,Integer.MAX_VALUE,1);
    }
    public int dfs(ArrayList<Edge> graph[],boolean vis[],int val,int curr){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
             val = Math.min(val,e.w);
            if(!vis[e.d]){
               val = Math.min(val, dfs(graph,vis,val,e.d));
            }
        }
        return val;
    }
}
