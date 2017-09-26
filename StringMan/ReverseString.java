public class ReverseString {
  public static void main(String args[]) {
    String s = "hello";
    System.out.println(new Solution().reverseString(s));
  }
}
class Solution {
    public String reverseString(String s) {
      char a[] = s.toCharArray();
      for(int i = 0, j = a.length - 1; i < j; i++, j--) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
      return new String(a);
    }
}
