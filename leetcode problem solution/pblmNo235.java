//235. Lowest Common Ancestor of a Binary Search Tree
public class pblmNo235 {
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
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){

            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }

            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }

            else{
                return root;
            }
        }

        return null;
    }
}
