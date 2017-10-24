public class LCABT {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(6);
    System.out.println(LCA(root, root, root.left.right).val);
  }
  private static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return null;

    if(root == p || root == q) return root;

    TreeNode l = LCA(root.left, p, q);
    TreeNode r = LCA(root.right, p, q);
    if(l != null && r != null) return root;
    else if (l == null && r == null) return null;
    else {
      return l != null ? l : r;
    }
  }
}

/*
Classic Solution: The idea is to goto left and right in the hope of finding p and q.
-You will find p and q somewhere in the tree.
-Return the FIRST parent whose left has p and right has q or vice versa.
- O(n)
*/
