public class RecStringRev {
  public static void main(String args[]) {
    String s = "abcdef";
    System.out.println(recReverse(s));
  }
  private static String recReverse(String s) {
    char a[] = s.toCharArray();
    reverse(a, 0);
    return new String(a);
  }
  private static void reverse(char a[], int curr) {
    if(curr > a.length - 1) {
      return;
    }
    char prev = a[curr];
    reverse(a, curr + 1);
    a[a.length - curr - 1] = prev;
  }
}
