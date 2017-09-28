public class MaxDepth {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(10);
    root.right = new TreeNode(20);
    root.left = new TreeNode(40);
    root.right = new TreeNode(50);
    root.right.left = new TreeNode(50);
    System.out.println(new Solution().maxDepth(root));
  }
}
class Solution {
  public int maxDepth(TreeNode root) {
    if(root == null) return 0;
    return maxDepth(root, 1);
  }
  public int maxDepth(TreeNode root, int level) {
    if(root == null) return level;
    if(root.left == null && root.right == null) {
      return level;
    }
    return Math.max(maxDepth(root.right, level + 1), maxDepth(root.left, level + 1));
  }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
/*
Count the number of nodes from root to deepest leaf. 
*/
