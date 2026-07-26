//2477. Minimum Fuel Cost to Report to the Capital

import java.util.ArrayList;

public class pblmNo2477 {
    long count = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<Integer> graph[] = new ArrayList[roads.length+1];
        for(int i=0;i<=roads.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++){
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        boolean vis[] = new boolean[roads.length+1];
        dfs(graph,seats,0,vis);
        return count;
    }
    public long dfs(ArrayList<Integer> graph[],int seats,int curr,boolean vis[]){
        vis[curr] = true;
        long people =1;
        for(int i=0;i<graph[curr].size();i++){
            int temp = graph[curr].get(i);
            if(!vis[temp]){
                long childPeople = dfs(graph,seats,temp,vis);;
                count += (childPeople + seats - 1) / seats;
                people += childPeople;
            }
        }
        return people;
    }
}
