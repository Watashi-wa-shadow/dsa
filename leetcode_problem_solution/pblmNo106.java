//106. Construct Binary Tree from Inorder and Postorder Traversal


public class pblmNo106 {
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
    int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) return null;

        // root from postorder
        int val = postorder[postIdx--];
        TreeNode root = new TreeNode(val);

        // finding index manually in inorder
        int idx = left;
        while (inorder[idx] != val) {
            idx++;
        }
        // building right first 
        root.right = helper(inorder, postorder, idx + 1, right);
        root.left = helper(inorder, postorder, left, idx - 1);

        return root;
    }
}
