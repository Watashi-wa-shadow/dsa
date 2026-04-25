//515. Find Largest Value in Each Tree Row

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class pblmNo515 {
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
     public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            result.add(max);
        }

        return result;
    }
}
