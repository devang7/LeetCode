import java.util.*;
public class KClosestBST {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(6);
    double target = 8.00;
    int k = 3;
    System.out.println(new Solution().closestKValues(root, target, k));
  }
}
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
      Stack<TreeNode> prev = new Stack<>();
      Stack<TreeNode> next = new Stack<>();
      TreeNode node = root;
      double diff = Math.abs(target - root.val);
      TreeNode diffNode = root;
      List<Integer> result = new ArrayList<>();
      if(k <= 0) return result;
      while(node != null) {
        if(diff > Math.abs(target - node.val)) {
            diff = Math.abs(target - node.val);
            diffNode = node;
        }
        next.push(node);
        prev.push(node);
        if(target > node.val) {
          node = node.right;
        } else {
          node = node.left;
        }
      }
      while(!prev.isEmpty() && prev.peek() != diffNode) {     //IMP STEP
          prev.pop();
          next.pop();
      }
      TreeNode curr = diffNode;
      result.add(curr.val);
      k--;
      TreeNode prevN = prevNode(prev, curr);
      TreeNode nextN = nextNode(next, curr);
      while(k > 0 && prevN != null && nextN != null) {
        double prevD = Math.abs(target - prevN.val);
        double nextD = Math.abs(target - nextN.val);
        if(prevD < nextD) {
          result.add(prevN.val);
          prevN = prevNode(prev, prevN);
        } else {
          result.add(nextN.val);
          nextN = nextNode(next, nextN);
        }
        k--;
      }
      while(k > 0 && nextN != null) {
        result.add(nextN.val);
        nextN = nextNode(next, nextN);
        k--;
      }
      while(k > 0 && prevN != null) {
        result.add(prevN.val);
        prevN = prevNode(prev, prevN);
        k--;
      }
      return result;
    }
    private TreeNode prevNode(Stack<TreeNode> prev, TreeNode curr) {
      if(curr == null) return null;
      if(curr.left != null) {
        prev.push(curr);
        TreeNode node = curr.left;
        while(node.right != null) {
          prev.push(node);
          node = node.right;
        }
        return node;
      }
      while(!prev.isEmpty()) {
        TreeNode node = prev.pop();
        if(node.right == curr) return node;
        curr = node;
      }
      return null;
    }
    private TreeNode nextNode(Stack<TreeNode> next, TreeNode curr) {
      if(curr == null) return null;
      if(curr.right != null) {
        next.push(curr);
        TreeNode node = curr.right;
        while(node.left != null) {
          next.push(node);
          node = node.left;
        }
        return node;
      }
      while(!next.isEmpty()) {
        TreeNode node = next.pop();
        if(node.left == curr) return node;
        curr = node;
      }
      return null;
    }
}

/*
=> Its very important not to stop once the difference decreases. The closest Node can be anywhere.
=> Find the closest node, Its important to clean up the stack.
*/
