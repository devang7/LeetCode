import java.util.*;
public class RepeatedDNA {
  public static void main(String args[]) {
    String s = "AAAAAAAAAAAAAA";
    System.out.println(new Solution().findRepeatedDnaSequences(s));
  }
}
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      char a[] = s.toCharArray();
      int i = 0;
      int j = 10;
      Set<String> set = new HashSet<>();
      Set<String> list = new HashSet<>();
      while(j <= s.length()) {
        String t = s.substring(i, j);
        if(set.contains(t)) {
          list.add(t);
        } else {
          set.add(t);
        }
        i++;
        j++;
      }
      return new ArrayList<>(list);
    }
}
/*
=> Make sure the result is also a set, as it can contain More than one repeated sequences.
*/
