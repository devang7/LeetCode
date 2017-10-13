import java.util.*;
public class ShortestWordDistance2 {
    public static void main(String args[]) {
      String words[] = new String[]{"practice", "makes", "perfect", "coding", "makes"};
      String word1 = "practice";
      String word2 = "coding";
      WordDistance w = new WordDistance(words);
      System.out.println(w.shortest(word1, word2));
    }
}
class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
      map = new HashMap<>();
      int i = 0;
      for(String w : words) {
        if(map.containsKey(w)) {
          List<Integer> list = map.get(w);
          list.add(i++);
        } else {
          List<Integer> list = new ArrayList<>();
          list.add(i++);
          map.put(w, list);
        }
      }
    }

    public int shortest(String word1, String word2) {
      List<Integer> l1 = map.get(word1);
      List<Integer> l2 = map.get(word2);
      return distance(l1, l2);
    }

    public int distance(List<Integer> l1, List<Integer> l2) {
      int i = 0;
      int j = 0;
      int sh = Integer.MAX_VALUE;
      while(i < l1.size() && j < l2.size()) {
        int f1 = l1.get(i);
        int f2 = l2.get(j);
        sh = Math.min(sh, Math.abs(f1 - f2));
        if(f1 <= f2) i++;
        else j++;
      }
      return sh;
    }
}

/*
Once you get the lists of indexes. Its important how you iterate it.
Take difference of the two indices. Increment the lower one. 
*/
