public class InvertBinaryTree {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(6);
    System.out.println(new LevelOrder().printLevelOrder(root));
    TreeNode invert = new Solution().invertTree(root);
    System.out.println(new LevelOrder().printLevelOrder(invert));
  }
}
class Solution {
    public TreeNode invertTree(TreeNode root) {
      if(root == null) return null;
      if(root.right == null && root.left == null) return root;
      TreeNode left = invertTree(root.left);
      TreeNode right = invertTree(root.right);
      root.right = left;
      root.left = right;
      return root;
    }
}
