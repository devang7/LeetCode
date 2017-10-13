import java.util.*;
public class SerializeDeBT {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.left.left = new TreeNode(4);
    System.out.println(new LevelOrder().recursiveLevelOrder(root));
    String data = new Codec().serialize(root);
    System.out.println(data);
    TreeNode r = new Codec().deserialize(data);
    System.out.println(new LevelOrder().recursiveLevelOrder(r));
  }
}
class Codec {

    // Encodes a tree to a single string.
    private static final String LEAF = "#";
    private static final String DELIMITER = " ";
    public String serialize(TreeNode root) {
      if(root == null) return null;
      StringBuilder br = new StringBuilder();
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()) {
        TreeNode curr = q.poll();
        if(curr == null) {
          br.append(LEAF + DELIMITER);
        } else {
          br.append(curr.val + DELIMITER);
        }
        if(curr != null) {
          q.add(curr.left);
          q.add(curr.right);
        }
      }
      return br.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if(data == null || data.isEmpty()) return null;
      String s[] = data.split(" ");
      Queue<TreeNode> q = new LinkedList<>();
      int index = 0;
      TreeNode root = new TreeNode(Integer.parseInt(s[index++]));
      q.add(root);
      while(!q.isEmpty()) {
        TreeNode curr = q.poll();
        String left = s[index++];
        String right = s[index++];
        if(!left.equals(LEAF)) {
          curr.left = new TreeNode(Integer.parseInt(left));
          q.add(curr.left);
        }
        if(!right.equals(LEAF)) {
          curr.right = new TreeNode(Integer.parseInt(right));
          q.add(curr.right);
        }
      }
      return root;
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
