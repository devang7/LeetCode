import java.util.*;
public class ValidNumber {
  public static void main(String args[]) {
    String s = "123e13";
    System.out.println(new Solution().isNumber(s));
  }
}
class Solution {
    Set<Character> numbers = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
    public boolean isNumber(String s) {
      s = s.trim();
      char a[] = s.toCharArray();
      if(s.contains("e")) {
        String left = s.substring(0, s.indexOf('e'));
        String right = s.substring(s.indexOf('e') + 1, s.length());
        return pureNumber(left, false) && pureNumber(right, true);
      } else {
        return pureNumber(s, false);
      }
    }
    public boolean pureNumber(String s, boolean decimalSeen) {
      if(s.length() <= 0) return false;
      if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
      boolean num = false;
      for(int i = 0; i < s.length(); i++) {
        if(!decimalSeen && s.charAt(i) == '.') {
          decimalSeen = true;
          continue;
        }
        if(!numbers.contains(s.charAt(i))) {
          return false;
        }
        num = true;
      }
      return num;
    }
}
/*
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
First Gather Requirement:
  What all symbols can be there.
  1. e only once for exponent: left and right should be a number
  2. - denoting negative: Can only be at the start of a number
  3. . denoting decimal: Right should be positive, left can be negative
  4. Can have a '+' sign as well
Corner Cases which I couldn't think:
1. "."
2. "e"
3. "0e"
4. "+.8"
5. "7e69e"  //split wont work here
*/
