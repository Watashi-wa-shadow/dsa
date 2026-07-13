//563. Binary Tree Tilt


public class pblmNo563 {
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
    int totalTilt = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return totalTilt;
    }
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        totalTilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
