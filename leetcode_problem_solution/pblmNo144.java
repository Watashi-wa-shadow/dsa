//144. Binary Tree Preorder Traversal

import java.util.ArrayList;
import java.util.List;

public class pblmNo144 {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        inorder(node.left, res);
        inorder(node.right, res);
    }
}
