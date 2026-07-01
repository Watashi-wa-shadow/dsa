//108. Convert Sorted Array to Binary Search Tree
public class pblmNo108 {
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
  public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }
    public TreeNode create(int nums[], int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = create(nums, start, mid - 1);
        root.right = create(nums, mid + 1, end);

        return root;
    }
}
