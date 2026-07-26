//547. Number of Provinces

import java.util.LinkedList;
import java.util.Queue;

public class pblmNo547 {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                provinces++;
                q.offer(i);
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    if (!vis[curr]) {
                        vis[curr] = true;
                        for (int j = 0; j < n; j++) {
                            if (isConnected[curr][j] == 1 && !vis[j]) {
                                q.offer(j);
                            }
                        }
                    }
                }
            }
        }
        return provinces;
    }
}
