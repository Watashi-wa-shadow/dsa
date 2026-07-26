//1466. Reorder Routes to Make All Paths Lead to the City Zero

import java.util.ArrayList;

public class pblmNo1466 {
    public class edge{
        int s,d,w;
        edge(int s,int d,int w){
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<edge> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<connections.length;i++){
            int src = connections[i][0];
            int dest = connections[i][1];
            graph[src].add(new edge(src,dest,1));
            graph[dest].add(new edge(dest,src,-1));
        }
        boolean vis[] = new boolean[n];
        return n-1-dfs(graph,0,vis,0);
    }
    public int dfs(ArrayList<edge> graph[],int curr,boolean vis[],int count){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.d]){
                if(e.w == -1)
                count++;
                count = dfs(graph,e.d,vis,count);
            }
        }
        return count;
    }
}
