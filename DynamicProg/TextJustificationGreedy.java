import java.util.*;
public class TextJustificationGreedy {
  public static void main(String args[]) {
    String words[] = new String[]{"a","b","c"};
    int maxWidth = 3;
    System.out.println(new Solution().fullJustify(words, maxWidth));
  }
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
      Map<String, Integer> map = new HashMap<>();
      for(String w : words) {
        map.put(w, w.length() + 1);
      }
      List<String> list = new ArrayList<>();
      int j = 0;
      while(j < words.length) {
        int count = 0;
        int prevCount = 0;
        int wordCount = 0;
        int i = j;
        while(i < words.length) {
          count += map.get(words[i]);
          if(count - 1 > maxWidth) break;
          wordCount += words[i].length();
          i++;
        }
        if(i >= words.length) break;      //words can fit in the last line
        int remChars = maxWidth - wordCount;
        int gaps = i - j - 1;
        int spaces = remChars;
        if(gaps != 0) {
          spaces = (int)Math.ceil(remChars / (double) gaps);
        }
        StringBuilder br = new StringBuilder();
        while(j < i) {
          br.append(words[j]);
          br.append(spaceGen(spaces));
          remChars -= spaces;
          gaps--;
          spaces = remChars;
          if(gaps > 0) spaces = (int)Math.ceil(remChars / (double) gaps);
          j++;
        }
        list.add(br.toString());
      }
      if(j < words.length) {        //Handling Last Line Exception
        int w = maxWidth;
        StringBuilder bd = new StringBuilder();
        while(j < words.length) {
          if(!words[j].isEmpty()) {
            bd.append(words[j] + " ");
            w -= map.get(words[j]);
          }
          j++;
        }
        if(w < 0) bd.setLength(bd.length() - 1);
        bd.append(spaceGen(w));
        list.add(bd.toString());
      }
      return list;
    }
    private String spaceGen(int n) {
      StringBuilder br = new StringBuilder();
      for(int i = 0; i < n; i++) {
        br.append(" ");
      }
      return br.toString();
    }
}
