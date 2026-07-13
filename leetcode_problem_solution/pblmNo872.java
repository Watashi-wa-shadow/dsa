//872. Leaf-Similar Trees

import java.util.ArrayList;
import java.util.List;



public class pblmNo872 {
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
     public void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }
}
