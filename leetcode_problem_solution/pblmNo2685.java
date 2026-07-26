//2685. Count the Number of Complete Components

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pblmNo2685 {
    public int countCompleteComponents(int n, int[][] edges) {
        int ans = 0;
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer>[] graph = new ArrayList[n];
        int node,edge;
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            node = 0;
            edge = 0;
            if (!vis[i]) {
                q.offer(i);

                while (!q.isEmpty()) {
                    int curr = q.poll();

                    if (vis[curr]) continue;

                    vis[curr] = true;
                    node++;
                    edge += graph[curr].size();
                    for (int next : graph[curr]) {
                        if (!vis[next]) {
                            q.offer(next);
                        }
                    }
                }
                if(node*(node-1) == edge)
                    ans++;
            }
        }
        return ans;
    }
}
