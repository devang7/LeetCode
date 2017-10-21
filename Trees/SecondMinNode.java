public class SecondMinNode {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    //root.left.right = new TreeNode(5);
    //root.left.left = new TreeNode(4);
    System.out.println(new Solution().findSecondMinimumValue(root));
  }
}
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
      if(root == null) return -1;
      return findMin(root, root.val);
    }
    public int findMin(TreeNode root, int val) {
      if(root == null) return -1;
      if(root.val > val) return root.val;
      int x = findMin(root.left, root.val);
      int y = findMin(root.right, root.val);
      if(x != -1 && y != -1) return Math.min(x,y);
      if(x != -1) return x;
      if(y != -1) return y;
      return -1;
    }
}
