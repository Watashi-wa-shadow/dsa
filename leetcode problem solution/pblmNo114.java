//114. Flatten Binary Tree to Linked List

public class pblmNo114{
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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        preorder(root);
    }
    public void preorder(TreeNode root) {
        if (root == null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (prev != null) {
            prev.right = root;
            prev.left = null;
        }

        // current node must also have left = null
        root.left = null;

        prev = root;

        preorder(left);
        preorder(right);
    }
}