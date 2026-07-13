//449. Serialize and Deserialize BST

import java.util.ArrayList;
import java.util.List;

public class pblmNo449 {
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
   int idx = -1;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();

        build(root, list);

        return String.join(" ", list);
    }
    public void build(TreeNode root, List<String> list) {

        if (root == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(root.val));

        build(root.left, list);
        build(root.right, list);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         idx = -1;

        String arr[] = data.split(" ");

        return create(arr);
    }
     public TreeNode create(String arr[]) {

        idx++;

        if (idx >= arr.length)
            return null;

        if (arr[idx].equals("null"))
            return null;

        TreeNode newnode = new TreeNode(Integer.parseInt(arr[idx]));

        newnode.left = create(arr);
        newnode.right = create(arr);

        return newnode;
    }
}

