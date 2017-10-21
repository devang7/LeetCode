import java.util.*;
public class BSTIter {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(6);
    BSTIterator i = new BSTIterator(root);
    while(i.hasNext()) {
      System.out.println(i.next());
    }
  }
}
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
      st = new Stack<>();
      while(root != null) {
        st.push(root);
        root = root.left;
      }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
      TreeNode curr = st.pop();
      if(curr.right != null) {
        TreeNode rightTree = curr.right;
        while(rightTree != null) {
          st.push(rightTree);
          rightTree = rightTree.left;
        }
      }
      return curr.val;
    }
}
