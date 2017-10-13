import java.util.*;
public class BTUpsideDown {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.left.left = new TreeNode(4);
    TreeNode r = new Solution().upsideDownBinaryTree(root);
    System.out.println(new LevelOrder().printLevelOrder(r));
  }
}
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
      if(root == null) return root;
      if(root.left == null && root.right == null) return root;
      TreeNode flipRoot = upsideDownBinaryTree(root.left);
      root.left.left = root.right;
      root.left.right = root;
      root.left = null;
      root.right = null;
      return flipRoot;
    }
}
class LevelOrder {
  public List<List<Integer>> printLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int currLevel = 1;
    int nextLevel = 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    List<Integer> list = new ArrayList<>();
    while(!q.isEmpty()) {
      TreeNode curr = q.poll();
      list.add(curr.val);
      currLevel--;
      if(curr.right != null) {
        nextLevel++;
        q.add(curr.right);
      }
      if(curr.left != null) {
        nextLevel++;
        q.add(curr.left);
      }
      if(currLevel == 0) {
        result.add(list);
        list = new ArrayList<>();
        currLevel = nextLevel;
        nextLevel = 0;
      }
    }
    return result;
  }
  public List<List<Integer>> recursiveLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, root, 0);
    return result;
  }
  private void helper(List<List<Integer>> result, TreeNode root, int level) {
      if(root == null) return;
      if(result.size() == level) {
        result.add(new ArrayList<>());
      }
      result.get(level).add(root.val);
      helper(result, root.left, level + 1);
      helper(result, root.right, level + 1);
  }
}

/*
=> All modifications on root.left
1.root.left.left becomes root.right
2.root.left.right becomes root
3.root becomes a leaf node
*/
