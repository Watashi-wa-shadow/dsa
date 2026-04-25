//94. Binary Tree Inorder Traversal

import java.util.ArrayList;
import java.util.List;



public class pblmNo94 {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;

        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}
