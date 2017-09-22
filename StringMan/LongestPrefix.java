public class LongestPrefix {
  public static void main(String args[]) {
    String s[] = new String[]{"","a"};
    System.out.println(new Solution().longestCommonPrefix(s));
  }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return "";
        if(strs.length <= 0) return "";
        if(strs.length <= 1) return strs[0];
        int j = 0;
        int i = 1;
        while(j < strs[0].length()) {
            char s = strs[0].charAt(j);
            i = 1;
            while(i < strs.length) {
                if(j >= strs[i].length() || strs[i].charAt(j) != s)
                    break;
                i++;
            }
            if(i < strs.length) {
                break;
            }
            j++;
        }
        if(j >= strs[0].length()) i = 0;      //IMP Step
        return strs[i].substring(0, j);
    }
}

/*
=> Beware of corner cases.
*/
