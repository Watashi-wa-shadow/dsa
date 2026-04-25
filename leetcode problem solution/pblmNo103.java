//103. Binary Tree Zigzag Level Order Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class pblmNo103 {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode curr = q.remove();

                if(leftRight){
                    level.add(curr.val);
                } else {
                    level.add(0, curr.val);
                }

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            leftRight = !leftRight;
            result.add(level);
        }

        return result;
    }
}
