//947. Most Stones Removed with Same Row or Column

import java.util.ArrayList;

public class pblmNo947 {
    public int removeStones(int[][] stones) {
        ArrayList<Integer> graph[] = new ArrayList[stones.length];
        for(int i=0;i<stones.length;i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        boolean vis[] = new boolean[stones.length];
        int count = 0;

        for (int i = 0; i < stones.length; i++) {
            if (!vis[i]) {
                int size = dfs(graph, vis, i);
                count += size - 1;
            }
        }
        return count ;
    }
    public int dfs(ArrayList<Integer> graph[], boolean vis[], int curr) {
        vis[curr] = true;

        int size = 1;

        for (int i = 0; i < graph[curr].size(); i++) {
            int temp = graph[curr].get(i);

            if (!vis[temp]) {
                size += dfs(graph, vis, temp);
            }
        }

        return size;
    }
}
