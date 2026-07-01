//236. Lowest Common Ancestor of a Binary Tree
public class pblmNo236 {
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
  public TreeNode lowestCommonAncestor(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null)
            return null;

        if (head == p || head == q)
            return head;

        TreeNode left = lowestCommonAncestor(head.left, p, q);
        TreeNode right = lowestCommonAncestor(head.right, p, q);

        if (left != null && right != null)
            return head;

        return (left != null) ? left : right;
    }
}
