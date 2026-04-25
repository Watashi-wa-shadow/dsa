//513. Find Bottom Left Tree Value

import java.util.LinkedList;
import java.util.Queue;


public class pblmNo513 {
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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int bottomLeft = root.val;

        while (!q.isEmpty()) {
            int size = q.size();
            // first node in this level is leftmost
            bottomLeft = q.peek().val;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return bottomLeft;
    }
}
