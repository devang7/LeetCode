import java.util.*;

public class Zigzag {
  public static void main(String args[]) {
    String s = "PAYPALISHIRING";
    int numRows = 4;
    System.out.println(new Solution().convert(s, numRows));
  }
}
class Solution {
    public String convert(String s, int numRows) {
      List<char[]> list = new ArrayList<>();
      char input[] = s.toCharArray();
      int i = 0;
      boolean straight = true;
      boolean up = true;
      while(i < input.length) {
        if(straight) {
            char a[] = new char[numRows];
            int j = 0;
            while(j < a.length && i < input.length) {
              a[j++] = input[i++];
            }
            list.add(a);
            straight = !straight;
        } else {
            int j = numRows - 2;
            while(j >= 1 && i < input.length) {
              char a[] = new char[numRows];
              a[j--] = input[i++];
              list.add(a);
            }
            straight = !straight;
        }
      }
      return display(list, numRows);
    }

    public String display(List<char[]> list, int numRows) {
      StringBuilder br = new StringBuilder();
      for(int i = 0; i < numRows; i++) {
        for(char t[] : list) {
          if(t[i] != 0) {
            br.append(Character.toString(t[i]));
          }
        }
      }
      return br.toString();
    }
}


/*
P   A   H   N
A P L S I I G
Y   I   R
"PAHNAPLSIIGYIR"
=> Maintain straight, up boolean pointers, List of Characters
*/
