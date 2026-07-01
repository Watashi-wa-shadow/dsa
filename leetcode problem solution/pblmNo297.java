//297. Serialize and Deserialize Binary Tree

import java.util.ArrayList;
import java.util.List;

public class pblmNo297 {
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
   // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        build(root, list);
        return String.join(",", list);
    }
    private void build(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(root.val));
        build(root.left, list);
        build(root.right, list);
    }
    int idx = -1;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = -1;
        return buildTree(arr);
    }
    private TreeNode buildTree(String[] arr) {
        idx++;

        if (idx >= arr.length || arr[idx].equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx]));
        node.left = buildTree(arr);
        node.right = buildTree(arr);

        return node;
    }
}
