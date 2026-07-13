//113. Path Sum II

import java.util.ArrayList;
import java.util.List;

public class pblmNo113 {
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
   public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> sumPath = new ArrayList<>();

        k_sum(root, targetSum, sumPath, ans);

        return ans;
    }
    public void k_sum(TreeNode root, int target,ArrayList<Integer> sumPath,List<List<Integer>> ans) {

        if (root == null) {
            return;
        }

        sumPath.add(root.val);

        // leaf node + target matched
        if (root.left == null && root.right == null
                && root.val == target) {

            ans.add(new ArrayList<>(sumPath));
        }

        else {
            k_sum(root.left, target - root.val, sumPath, ans);
            k_sum(root.right, target - root.val, sumPath, ans);
        }

        sumPath.remove(sumPath.size() - 1);
    }
}
