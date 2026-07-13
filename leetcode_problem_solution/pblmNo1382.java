//1382. Balance a Binary Search Tree

import java.util.ArrayList;

public class pblmNo1382 {
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
  public TreeNode balanceBST(TreeNode root) {
         if(root == null)
            return null;

        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        return create(list, 0, list.size() - 1);
    }
     public void inOrder(TreeNode root, ArrayList<Integer> list) {
        if(root == null)
            return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public TreeNode create(ArrayList<Integer> list, int start, int end) {

        if(start > end)
            return null;

        int mid = (start + end) / 2;

        TreeNode newnode = new TreeNode(list.get(mid));

        newnode.left = create(list, start, mid - 1);

        newnode.right = create(list, mid + 1, end);

        return newnode;
    }
}
