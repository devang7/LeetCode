import java.util.*;

public class TextJustification {
  public static void main(String args[]) {
    String words[] = new String[]{"Here","is","an","example","of","text","justification."};
    int maxWidth = 14;
    System.out.println(new Solution().fullJustify(words, maxWidth));
  }
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
      int n = words.length;
      int len[] = new int[n+1];
      List<String> ans = new ArrayList<>();
      for(int i = 1; i <= n; i++) {
        len[i] = len[i - 1] + words[i-1].length();
      }
      int cost[][] = new int[n][n];
      for(int i = 0; i < n; i++) {
        int j = i;
        for(int k = j; k < n; k++) {
          cost[i][k] = (len[k + 1] - len[i]) + (k - i) > maxWidth ? Integer.MAX_VALUE : (int)Math.pow(maxWidth - ((len[k + 1] - len[i])), 2);
        }
      }
      int opt[] = new int[n];
      int back[] = new int[n];
      opt[0] = cost[0][0];
      back[0] = 0;
      for(int j = 1; j < n; j++) {
        int min = cost[0][j];
        back[j] = 0;
        for(int i = 0; i < j; i++) {
          if(cost[i+1][j] == Integer.MAX_VALUE) continue;
          if(min > opt[i] + cost[i+1][j]) {
            back[j] = i + 1;
            min = opt[i] + cost[i + 1][j];
          }
        }
        opt[j] = min;
      }
      int start = back[n - 1];
      int end = n - 1;
      while(end >= 0) {
        ans.add(makeSentence(words, start, end, maxWidth));
        end = start - 1;
        if(end < 0) {
          Collections.reverse(ans);
          return ans;
        }
        start = back[end];
      }
      Collections.reverse(ans);
      return ans;
    }
    private String makeSentence(String words[], int start, int end, int maxWidth) {
      StringBuilder br = new StringBuilder();
      int count = 0;
      int i = start;
      while(i <= end) {
        count += words[i].length();
        i++;
      }
      int spaces = maxWidth - count;
      if(start == end) {
        br.append(words[start]);
        br.append(spaceGenerator(spaces));
        return br.toString();
      }
      if(end == words.length - 1) {
        while(start <= end) {
          br.append(words[start] + " ");
          start++;
          spaces--;
        }
        br.append(spaceGenerator(spaces));
        return br.toString();
      }
      int gaps = end - start;
      int sp = (int)Math.ceil(spaces / (double)gaps);
      while(start < end) {
        br.append(words[start]);
        br.append(spaceGenerator(spaces < sp ? spaces : sp));
        spaces -= sp;
        start++;
      }
      br.append(words[end]);
      return br.toString();
    }
    private String spaceGenerator(int k) {
      StringBuilder br = new StringBuilder();
      while(k > 0) {
        br.append(" ");
        k--;
      }
      return br.toString();
    }
}

/*
=> This is actually Text justification Problem (with L to R align) from CLRS book, where the goal is to even out the spaces throughout the text.
=> The leetcode question on Text Justification wants us to greedy put words in a line, and just even out spaces for each line.
*/
