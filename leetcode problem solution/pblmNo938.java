//938. Range Sum of BST


public class pblmNo938 {
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;

        if(root.val >= low && root.val <= high){
            return root.val 
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
        }

        if(root.val > high)
            return rangeSumBST(root.left, low, high);

        return rangeSumBST(root.right, low, high);
    }
}
