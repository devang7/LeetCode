import java.util.*;

public class RemoveDupLetters {
  public static void main(String args[]) {
    String s = "cbacdcbc";
    System.out.println(new Solution().removeDuplicateLetters(s));
  }
}
class Solution {
    public String removeDuplicateLetters(String s) {
      Stack<Character> st = new Stack<>();
      int arr[] = new int[26];
      for(int i = 0; i < s.length(); i++) {
          arr[s.charAt(i) - 'a']++;
      }
      boolean visited[] = new boolean[26];
      for(int i = 0; i < s.length(); i++) {
        int index = s.charAt(i) - 'a';
        arr[index]--;
        if(visited[index]) continue;

        while(!st.isEmpty() && s.charAt(i) < st.peek() && arr[st.peek() - 'a'] > 0) {
          char remove = st.pop();
          visited[remove - 'a'] = false;
        }
        st.push(s.charAt(i));
        visited[index] = true;
      }
      StringBuilder br = new StringBuilder();
      while(!st.isEmpty()) {
        br.append(Character.toString(st.pop()));
      }
      return br.reverse().toString();
    }
}
/*
If you encounter a character which is lesser than the stack top and also has a duplicate remaining,
That can be added latter on.
Since every character is push and poped out ONLY once O(n)
*/
