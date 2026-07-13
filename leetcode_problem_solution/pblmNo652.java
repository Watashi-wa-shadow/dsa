//652. Find Duplicate Subtrees

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class pblmNo652 {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) {
          this.val = val;
          this.left = null;
          this.right = null;
      }
  }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        dfs(root, map, result);
        return result;
    }
    private String dfs(TreeNode root, HashMap<String, Integer> map, List<TreeNode> result) {
        if (root == null) return "#";

        String left = dfs(root.left, map, result);
        String right = dfs(root.right, map, result);

        String curr = root.val + "," + left + "," + right;

        map.put(curr, map.getOrDefault(curr, 0) + 1);

        if (map.get(curr) == 2) {
            result.add(root);
        }

        return curr;
    }
}
