//2050. Parallel Courses III

import java.util.ArrayList;

public class pblmNo2050 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] relation : relations) {
            graph[relation[1]].add(relation[0]);
        }
        int ans[] = new int[n+1];
        int miniTime = -1;
        for (int i = 1; i <= n; i++) {
            miniTime = Math.max(miniTime, dfs(i, graph, time, ans));
        }
        return miniTime;
    }
    public int dfs(int curr,ArrayList<Integer> reverseGraph[],int time[],int ans[]){
        if(ans[curr] != 0)
            return ans[curr];
        int best = 0;
        for(int i=0;i<reverseGraph[curr].size();i++){
            int temp = reverseGraph[curr].get(i);
            best = Math.max(best,dfs(temp,reverseGraph,time,ans));
        }
        ans[curr] = best + time[curr - 1];
        return ans[curr] ;
    }
}
