public class FlattenBT {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    root.left = t2;
    root.left.right = t4;
    root.left.left = t5;
    new Solution().flatten(root);
    while(root != null) {
      System.out.print(root.val + " -> ");
      root = root.right;
    }
  }
}

class Solution {
    public void flatten(TreeNode root) {
      if(root == null) return;
      root = flat(root);
    }

    private TreeNode flat(TreeNode root) {
      if(root == null) return root;
      if(root.right == null && root.left == null) {
        return root;
      }
      TreeNode left = flat(root.left);
      TreeNode right = flat(root.right);
      root.right = left != null ? left : right;
      /*Goto the tail of left - Optimize*/
      if(left != null) {
        TreeNode prev = null;
        while(left != null) {
          prev = left;
          left = left.right;
        }
        prev.right = right;
      }
      root.left = null;
      return root;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
