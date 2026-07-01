//257. Binary Tree Paths

import java.util.ArrayList;
import java.util.List;

public class pblmNo257 {
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
  public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        printRoot2Leaf(root, new ArrayList<>(), result);
        return result;
    }
    public void printRoot2Leaf(TreeNode root,ArrayList<Integer> path,List<String> result) {

        if (root == null)
            return;

        path.add(root.val);

        // Leaf node
        if (root.left == null && root.right == null) {
            result.add(createPath(path));
        } else {
            printRoot2Leaf(root.left, path, result);
            printRoot2Leaf(root.right, path, result);
        }
        path.remove(path.size() - 1);
    }

    public String createPath(ArrayList<Integer> path) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));

            if (i != path.size() - 1)
                sb.append("->");
        }

        return sb.toString();
    }
}
