//210. Course Schedule II

import java.util.ArrayList;
import java.util.Stack;

public class pblmNo210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            graph[src].add(dest);
        }
        int ans[] = new int[numCourses];
        return topSort(graph,numCourses,ans);
    }
    public static boolean isCyclic(ArrayList<Integer> graph[],boolean vis2[], int curr,boolean rec[]){
        vis2[curr] = true;
        rec[curr] = true;
        for (int temp : graph[curr]) {
            if (rec[temp])
                return true;
            if (!vis2[temp]) {
                if (isCyclic(graph, vis2, temp, rec))
                    return true;
            }
        }
        rec[curr] = false;
        return false;
    }
    public static void topSortUtil(ArrayList<Integer> graph[],int curr,boolean vis[],Stack<Integer> stack){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            int temp = graph[curr].get(i);
            if(!vis[temp]){
                topSortUtil(graph, temp, vis, stack);
            }
        }
        stack.push(curr);
    }
    public static int[] topSort(ArrayList<Integer> graph[],int v,int ans[]){
        boolean vis[] = new boolean[v];
        boolean val = false;
        boolean vis2[] = new boolean[v];
        boolean rec[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis2[i]) {
                if (isCyclic(graph, vis2, i, rec))
                    return new int[0];
            }
        }
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, stack);
            }
        }
        int i=0;
        while(!stack.isEmpty()){
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }
}
