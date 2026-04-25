//662. Maximum Width of Binary Tree

import java.util.LinkedList;
import java.util.Queue;



public class pblmNo662 {
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Long> index = new LinkedList<>();
        q.offer(root);
        index.offer(0L);
        int maxWidth = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            long first = index.peek(); // leftmost index
            long last = first;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                long curr = index.poll();

                last = curr; // updating last

                if (node.left != null) {
                    q.offer(node.left);
                    index.offer(2 * curr);
                }
                if (node.right != null) {
                    q.offer(node.right);
                    index.offer(2 * curr + 1);
                }
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }
}
