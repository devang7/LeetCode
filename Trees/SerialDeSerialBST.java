import java.util.*;

public class SerialDeSerialBST {

  public static void main(String args[]) {
    TreeNode root = new TreeNode(50);
    TreeNode l1 = new TreeNode(40);
    TreeNode l2 = new TreeNode(20);
    TreeNode r1 = new TreeNode(70);
    TreeNode r2 = new TreeNode(60);
    root.left = l1;
    root.right = r1;
    l1.left = l2;
    r1.left = r2;
    String input = new Codec().serialize(root);
    System.out.println(input);
    TreeNode output = new Codec().deserialize(input);
    System.out.println(new Codec().serialize(output));
  }
}
class Codec {

    int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder br = new StringBuilder();
      Stack<TreeNode> st = new Stack<TreeNode>();
      TreeNode node = root;
      while(node != null || !st.isEmpty()) {
          if(node != null) {
            br.append(node.val + " ");
            st.push(node);
            node = node.left;
          } else {
            node = st.pop().right;
          }
      }
      return br.toString().trim();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      index = 0;
      String in[] = data.split(" ");
      int pre[] = new int[in.length];
      int i = 0;
      for(String s : in) {
        pre[i++] = Integer.parseInt(s);
      }
      return BSTFromPreOrder(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode BSTFromPreOrder(int pre[], int min, int max) {
      if(index >= pre.length) return null;
      TreeNode root = null;
      if(pre[index] > min && pre[index] < max) {
          root = new TreeNode(pre[index++]);
          root.left = BSTFromPreOrder(pre, min, root.val);
          root.right = BSTFromPreOrder(pre, root.val, max);
      }
      return root;
    }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
 }
