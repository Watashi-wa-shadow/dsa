//199. Binary Tree Right Side View

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pblmNo199 {
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        boolean isFirst = true;

        while(!q.isEmpty()){
            TreeNode curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                isFirst = true;
                q.add(null);
            }
            else{
                if(isFirst){
                    ans.add(curr.val);
                    isFirst = false;
                }

                if(curr.right != null){
                    q.add(curr.right);
                }

                if(curr.left != null){
                    q.add(curr.left);
                }
            }
        }

        return ans;
    }
}
