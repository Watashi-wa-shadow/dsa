//1305. All Elements in Two Binary Search Trees

import java.util.ArrayList;
import java.util.List;

public class pblmNo1305 {
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
   public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
         ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        inOrder(root1, list1);
        inOrder(root2, list2);

        int j = 0, k = 0;

        while(j < list1.size() && k < list2.size()) {

            if(list1.get(j) < list2.get(k)) {
                list3.add(list1.get(j));
                j++;
            }
            else {
                list3.add(list2.get(k));
                k++;
            }
        }

        while(j < list1.size()) {
            list3.add(list1.get(j));
            j++;
        }

        while(k < list2.size()) {
            list3.add(list2.get(k));
            k++;
        }

        return list3;
    }
     public void inOrder(TreeNode root, ArrayList<Integer> list) {
        if(root == null)
            return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
