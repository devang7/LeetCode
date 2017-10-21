import java.util.*;
public class MinSt {
  public static void main(String args[]) {
    MinStack ms = new MinStack();
    ms.push(2);
    ms.push(5);
    ms.push(1);
    ms.push(1);
    System.out.println(ms.getMin());
    ms.pop();
    System.out.println(ms.getMin());
  }
}
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> mStack;
    Stack<Integer> min;
    public MinStack() {
      mStack = new Stack<>();
      min = new Stack<>();
    }

    public void push(int x) {
      mStack.push(x);
      if(min.isEmpty() || x <= min.peek()) {
        min.push(x);
      }
    }

    public void pop() {
      int x = mStack.pop();
      if(!min.isEmpty() && x == min.peek()) min.pop();
    }

    public int top() {
      return mStack.peek();
    }

    public int getMin() {
      return min.peek();
    }
}
