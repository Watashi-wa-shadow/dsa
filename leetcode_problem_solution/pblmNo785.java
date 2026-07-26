//785. Is Graph Bipartite?
public class pblmNo785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                color[i] = 1;
                if (!help(graph, i, vis, color))
                    return false;
            }
        }
        return true;
    }

    public boolean help(int[][] graph, int curr, boolean vis[], int color[]) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].length; i++) {
            int temp = graph[curr][i];

            if (color[curr] == color[temp])
                return false;

            if (color[temp] == 0) {
                if (color[curr] == 1)
                    color[temp] = 2;
                else
                    color[temp] = 1;
            }

            if (!vis[temp]) {
                if (!help(graph, temp, vis, color))
                    return false;
            }
        }
        return true;
    }
}
