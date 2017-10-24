public class LCABSTIter {
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
    TreeNode node = root;
    while(node != null) {
      if(p.val > node.val && q.val > node.val) node = node.right;
      else if(p.val < node.val && q.val < node.val) node = node.left;
      else return node;
    }
    return null;
  }
}
