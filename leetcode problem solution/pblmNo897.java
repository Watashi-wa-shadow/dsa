//897. Increasing Order Search Tree
public class pblmNo897 {
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
  TreeNode dummy = new TreeNode(-1);
    TreeNode curr = dummy;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return dummy.right;
    }
    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        root.left = null;
        curr.right = root;
        curr = root;

        inorder(root.right);
    }
}
