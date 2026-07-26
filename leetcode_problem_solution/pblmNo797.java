//797. All Paths From Source to Target

import java.util.ArrayList;
import java.util.List;

public class pblmNo797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        sourceToPath(graph, 0, graph.length - 1, path, ans);
        return ans;
    }
    public void sourceToPath(int[][] graph, int curr, int target,List<Integer> path, List<List<Integer>> ans) {
        path.add(curr);
        if (curr == target) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (int i = 0; i < graph[curr].length; i++) {
            sourceToPath(graph, graph[curr][i], target, path, ans);
        }
        path.remove(path.size() - 1);
    }
}
