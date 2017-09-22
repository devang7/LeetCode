import java.util.*;

public class LetterComb {
  public static void main(String args[]) {
    String digits = "242";
    System.out.println(new Solution().letterCombinations(digits));
  }
}
class Solution {
    Map<Integer, String> map;
    public List<String> letterCombinations(String digits) {
      map = new HashMap<Integer, String>();
      map.put(2, "abc");
      map.put(3, "def");
      map.put(4, "ghi");
      map.put(5, "jkl");
      map.put(6, "mno");
      map.put(7, "pqrs");
      map.put(8, "tuv");
      map.put(9, "wxyz");
      List<String> ans = new ArrayList<>();
      if(digits == null || digits.length() <= 0) return ans;
      int nums[] = new int[digits.length()];
      for(int i = 1; i <= digits.length(); i++) {
        nums[i - 1] = Integer.parseInt(digits.substring(i - 1, i));
        if(nums[i - 1] <= 1) return ans;
      }
      StringBuilder br = new StringBuilder();
      int start = 0;
      calCombinations(ans, br, start, nums);
      return ans;
    }

    public void calCombinations(List<String> ans, StringBuilder br, int start, int nums[]) {
      if(br.length() == nums.length) {
        ans.add(br.toString());
        return;
      }
      char set[] = map.get(nums[start]).toCharArray();
      for(char c : set) {
        br.append(Character.toString(c));
        calCombinations(ans, br, start + 1, nums);
        br.setLength(br.length() - 1);
      }
    }
}
