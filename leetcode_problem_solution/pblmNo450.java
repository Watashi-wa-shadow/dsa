//450. Delete Node in a BST

public class pblmNo450 {
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
  public TreeNode deleteNode(TreeNode root, int key) {
         if (root == null)
            return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } 
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } 
        else {

            // case 1: no child
            if (root.left == null && root.right == null)
                return null;

            // case 2: one child
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            // case 3: two children
            TreeNode is = inorderSuccessor(root.right);
            root.val = is.val;
            root.right = deleteNode(root.right, is.val);
        }

        return root;
    }
    public TreeNode inorderSuccessor(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
