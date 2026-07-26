//886. Possible Bipartition

import java.util.ArrayList;

public class pblmNo886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        boolean vis[] = new boolean[n+1];
        int color[] = new int[n+1];
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            graph[i] = new ArrayList<>();
        for(int i=0;i<dislikes.length;i++){
            int src = dislikes[i][0];
            int dest = dislikes[i][1];
            graph[src].add(dest);
            graph[dest].add(src);
        }
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                color[i] = 1;
                if(!help(graph,i,vis,color))
                    return false;
            }
        }
        return true;
    }
    public boolean help(ArrayList<Integer> graph[],int curr,boolean vis[],int color[]){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            int temp = graph[curr].get(i);
            if(color[curr] != 0 && color[curr] == color[temp])
                return false;
            if(color[temp] == 0){
                if(color[curr] == 1)
                    color[temp] = 2;
                else
                    color[temp] = 1;
            }
            if(!vis[temp]){
                if(!help(graph,temp,vis,color))
                    return false;
            }
        }
        return true;
    }
}
