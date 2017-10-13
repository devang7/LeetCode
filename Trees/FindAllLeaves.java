import java.util.*;
public class FindAllLeaves {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.left.left = new TreeNode(4);
    System.out.println(new Optimal().findLeaves(root));
  }
}
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      while(true) {
        List<Integer> list = new ArrayList<>();
        TreeNode r = getLeaves(list, root, true, root);
        result.add(list);
        if(r == null) break;
      }
      return result;
    }
    public TreeNode getLeaves(List<Integer> list, TreeNode prev, boolean isLeft, TreeNode root) {
      if(root == null) return prev;
      if(root.left == null && root.right == null) {
        list.add(root.val);
        if(isLeft) prev.left = null;
        else prev.right = null;
        if(prev == root) root = null;
        return root;
      }
      TreeNode right = getLeaves(list, root, true, root.left);
      TreeNode left = getLeaves(list, root, false, root.right);
      return left;
    }
}
class Optimal {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, root);
    return result;
  }
  public int helper(List<List<Integer>> result, TreeNode root) {
    if(root == null) return -1;
    int h = 1 + Math.max(helper(result, root.left), helper(result, root.right));
    if(result.size() == h) {
      result.add(new ArrayList<>());
    }
    result.get(h).add(root.val);
    return h;
  }
}
/*
=> The first approach is brute force. Go to all the leaves and prune the leaves once node is added to the list.
   This would take O(h*n) where h = height of the tree. O(n^2) worst case

=> The better approach is to realize that the index in the result list is the height of the node. Height is defined as
   no of edges to the deepest leaf. Build the result in bottom up fashion.
*/
