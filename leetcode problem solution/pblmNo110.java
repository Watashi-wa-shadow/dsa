//110. Balanced Binary Tree



public class pblmNo110 {
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
    public int balanceCheck(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = balanceCheck(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = balanceCheck(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return balanceCheck(root) != -1;
    }
}
