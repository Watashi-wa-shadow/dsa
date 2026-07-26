//2192. All Ancestors of a Node in a Directed Acyclic Graph

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pblmNo2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            graph[edges[i][1]].add(edges[i][0]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            boolean vis[] = new boolean[n];
            dfs(graph, i, vis,list);
            Collections.sort(list);
            ans.add(new ArrayList<>(list));
            list.clear();
        }
        return ans;
    }
    public void dfs(List<Integer> graph[],int curr,boolean vis[],List<Integer> list){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            int temp = graph[curr].get(i);
            if(!vis[temp]){
                list.add(temp);
                dfs(graph, temp, vis,list);
            }
        }
    }
}
