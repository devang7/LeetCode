import java.util.*;
public class WordLadder {
  public static void main(String args[]) {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<>(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
    System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
  }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        int currLevel = 1;
        int nextLevel = 0;
        while(!q.isEmpty()) {
           String word = q.poll();
           currLevel--;
           if(word.equals(endWord)) return level;
           char w[] = word.toCharArray();
           for(int i = 0; i < w.length; i++) {
               for(int j = 0; j < 26; j++) {
                   char prev = w[i];
                   w[i] = (char) (j + 'a');
                   String nextPossible = new String(w);
                   if(dict.contains(nextPossible)) {
                       q.add(nextPossible);
                       nextLevel++;
                   }
                   w[i] = prev;
               }
           }
           if(currLevel == 0) {
               currLevel = nextLevel;
               nextLevel = 0;
               level++;
           }
        }
        return -1;
    }
}
