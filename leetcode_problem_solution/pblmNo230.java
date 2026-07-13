//230. Kth Smallest Element in a BST

import java.util.ArrayList;

public class pblmNo230 {
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
   public int kthSmallest(TreeNode root, int k) {
         ArrayList<Integer> store = new ArrayList<>();

        if (root == null)
            return -9999;

        inorder(store, root);

        if (k > store.size())
            return -9999;

        return store.get(k - 1);
    }
    public void inorder(ArrayList<Integer> store, TreeNode root) {
        if (root == null)
            return;

        inorder(store, root.left);
        store.add(root.val);
        inorder(store, root.right);
    }
}
