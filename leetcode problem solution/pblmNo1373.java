//1373. Maximum Sum BST in Binary Tree
public class pblmNo1373 {
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
  int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        check(root);
        return maxSum;
    }
    public int[] check(TreeNode node) {

        if (node == null)
            return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] left = check(node.left);
        int[] right = check(node.right);

        // Check if current subtree forms a BST
        if (left[0] == 1 && right[0] == 1 && node.val > left[3] &&  node.val < right[2]) {

            int sum = node.val + left[1] + right[1];

            maxSum = Math.max(maxSum, sum);

            int min = Math.min(node.val, left[2]);
            int max = Math.max(node.val, right[3]);

            return new int[]{1, sum, min, max};
        }

        int min = Math.min(node.val,Math.min(left[2], right[2]));

        int max = Math.max(node.val,Math.max(left[3], right[3]));

        return new int[]{0, 0, min, max};
    }
}
