//207. Course Schedule

import java.util.ArrayList;

public class pblmNo207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            graph[src].add(dest);
        }
        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];
        boolean val = false;
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                val = isCyclic(graph, vis, i, rec);
                if(val)
                    break;
            }
        }
        return !val;
    }
    public boolean isCyclic(ArrayList<Integer> graph[],boolean vis[], int curr,boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;
        for (int temp : graph[curr]) {
            if (rec[temp])
                return true;
            if (!vis[temp]) {
                if (isCyclic(graph, vis, temp, rec))
                    return true;
            }
        }
        rec[curr] = false;
        return false;
    }
}
