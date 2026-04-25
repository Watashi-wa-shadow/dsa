//105. Construct Binary Tree from Preorder and Inorder Traversal
public class pblmNo105{
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
    static int idx = -1;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = -1;
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int preorder[], int inorder[], int start, int end){
        if(start > end){
            return null;
        }

        idx++;
        TreeNode newNode = new TreeNode(preorder[idx]);

        if(start == end){
            return newNode;
        }

        int pos = search(inorder, start, end, newNode.val);

        newNode.left = build(preorder, inorder, start, pos - 1);
        newNode.right = build(preorder, inorder, pos + 1, end);

        return newNode;
    }

    public int search(int arr[], int start, int end, int value){
        for(int i = start; i <= end; i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}