//107. Binary Tree Level Order Traversal II

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class pblmNo107 {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         LinkedList<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                level.add(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            ans.addFirst(level);
        }

        return ans;
    }
}
