public class ShortestWordDistance3 {
  public static void main(String args[]) {
    String words[] = new String[]{"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "makes";
    String word2 = "makes";
    System.out.println(new Solution().shortestWordDistance(words, word1, word2));
  }
}
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minA = -1;
        int minB = -1;
        int shortest = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        boolean f = true;
        boolean s = true;
        for(int i = 0; i < words.length; i++) {
          if(word1.equals(words[i]) && f) {
            if(same) {
              s = true;
              f = false;
            }
            minA = i;
            if(minB >= 0) shortest = Math.min(shortest, Math.abs(minA - minB));
          } else if(word2.equals(words[i]) && s) {
            if(same){
              f = true;
              s = false;
            }
            minB = i;
            if(minA >= 0) shortest = Math.min(shortest, Math.abs(minA - minB));
          }
        }
        return shortest;
    }
}

/*
Game of two flags, first and second to ensure you handle same word1 and word2 too.

word1 and word2 may be the same and they represent two individual words in the list.
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.
*/
