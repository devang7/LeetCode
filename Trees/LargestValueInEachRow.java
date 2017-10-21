import java.util.*;
public class LargestValueInEachRow {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.left.left = new TreeNode(4);
    System.out.println(new Solution().largestValues(root));
  }
}
class Solution {
    public List<Integer> largestValues(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      largestValue(root, list, 0);
      return list;
    }
    private void largestValue(TreeNode root, List<Integer> list, int level) {
      if(root == null) return;
      if(list.size() == level) list.add(Integer.MIN_VALUE);
      if(list.get(level) < root.val) list.set(level, root.val);
      largestValue(root.left, list, level + 1);
      largestValue(root.right, list, level + 1);
    }
}
