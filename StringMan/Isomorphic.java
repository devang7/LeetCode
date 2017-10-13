import java.util.*;
public class Isomorphic {
  public static void main(String args[]) {
    String s = "ab";
    String t = "ba";
    System.out.println(new Solution().isIsomorphic(s,t));
  }
}
class Solution {
    public boolean isIsomorphic(String s, String t) {
      int arr[] = new int[256];
      Arrays.fill(arr, -1);
      Set<Character> visited = new  HashSet<>();
      char si[] = s.toCharArray();
      char ti[] = t.toCharArray();
      for(int i = 0; i < si.length; i++) {
        if(arr[si[i]] == -1 && !visited.contains(ti[i])){
          arr[si[i]] = ti[i];
          visited.add(ti[i]);
        }
        if(arr[si[i]] == -1 && visited.contains(ti[i])) return false;
        if(arr[si[i]] != -1 && arr[si[i]] != ti[i]) return false;
      }
      return true;
    }
}

/*
=> 1. If the Character is mapped to another character, no other character can be mapped to that character
   visted set keeps track of characters that are mapped.
   2. If Character is mapped it should always be mapped to that character.
*/
