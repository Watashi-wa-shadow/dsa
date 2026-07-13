//700. Search in a Binary Search Tree
public class pblmNo700 {
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
   public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        if (root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}
