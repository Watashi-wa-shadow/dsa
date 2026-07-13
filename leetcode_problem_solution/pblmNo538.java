//538. Convert BST to Greater Tree

public class pblmNo538 {
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
  int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }
}
