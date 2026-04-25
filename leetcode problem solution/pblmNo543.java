//543. Diameter of Binary Tree



public class pblmNo543 {

     int diameter = 0;
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

    public int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}
