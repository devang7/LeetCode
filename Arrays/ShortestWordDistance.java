import java.util.*;

public class ShortestWordDistance {
  public static void main(String args[]) {
    String words[] = new String[]{"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "practice";
    String word2 = "coding";
    System.out.println(new Solution().shortestDistance(words, word1, word2));
  }
}
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int minA = -1;
        int minB = -1;
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
          if(words[i].equals(word1)) {
            minA = i;
            if(minB != -1) {
              shortest = Math.min(shortest, Math.abs(minA - minB));
            }
          } else if(words[i].equals(word2)) {
            minB = i;
            if(minA != -1) {
              shortest = Math.min(shortest, Math.abs(minA - minB));
            }
          }
        }
        return shortest;
    }
}


/*
=> Maintain two pointers to track the latest entry of the words.
=> Calculate the distance whenever the pointer updates.
O(n) Single Pass

Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
*/
