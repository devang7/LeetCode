import java.util.*;

public class SlidingWindowMax {
  public static void main(String args[]) {
    int nums[] = new int[]{-3,-2,-1,3,-5,-3,-6,-6};
    int k = 2;
    System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, k)));
  }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        PriorityQueue<Point> h1 = new PriorityQueue<>();
        PriorityQueue<Point> temp = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            h1.add(new Point(i, nums[i]));
        }
        int j = 0;
        ans[j++] = h1.peek().value;
        for(int i = k; i < n; i++) {
            temp.add(new Point(i,nums[i]));
            while(!h1.isEmpty() && h1.peek().index <= i - k) h1.poll();     //IMP STEP To remove stale Entries
            if(h1.isEmpty() || h1.peek().value < temp.peek().value) {
                h1 = temp;
                temp = new PriorityQueue<>();
            }
            ans[j++] = h1.peek().value;
        }
        return ans;
    }
}
class Point implements Comparable<Point> {
    int index;
    int value;
    Point(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int compareTo(Point x) {
        return -(new Integer(this.value).compareTo(x.value));
    }

    public String toString() {
      return "[" + value + "," + index + "]";
    }
}

/*
GAME OF TWO HEAPS!
=> Maintain two heaps h1 and temp. h1 stores the max value always.
=> Max can change in two conditions: 1. If h1.peek() < temp.peek() 2. If h1.peek().index <= i - k (out of window);
=> To Think: Can we keep Index Independent and save making Point class!
*/
