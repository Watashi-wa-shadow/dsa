//1008. Construct Binary Search Tree from Preorder Traversal
public class pblmNo1008 {
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
  int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
         return create(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
     public TreeNode create(int[] preorder, int min, int max) {

        if (idx >= preorder.length)
            return null;

        int val = preorder[idx];

        if (val < min || val > max)
            return null;

        idx++;

        TreeNode root = new TreeNode(val);

        root.left = create(preorder, min, val);
        root.right = create(preorder, val, max);

        return root;
     }
}
