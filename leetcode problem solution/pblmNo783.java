//783. Minimum Distance Between BST Nodes

public class pblmNo783 {
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
    TreeNode predecessor = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        
        inorder(root);

        return min;
    }
     public void inorder(TreeNode head) {

        if(head == null)
            return;

        inorder(head.left);

        if(predecessor != null) {
            min = Math.min(min, head.val - predecessor.val);
        }

        predecessor = head;

        inorder(head.right);
    }
}
