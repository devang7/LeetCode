import java.util.*;
public class TopKFreqElements {
  public static void main(String args[]) {
    int nums[] = new int[]{1,2,2,1,1,5,6};
    int k = 1;
    System.out.println(new Solution().topKFreq(nums, k));
  }
}
class Solution {
  public List<Integer> topKFreq(int nums[], int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxFreq = 1;
    for(Integer i : nums) {
      if(map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
        maxFreq = Math.max(maxFreq, map.get(i) + 1);
      } else {
        map.put(i, 1);
      }
    }
    ArrayList<Integer> arr[] = new ArrayList[maxFreq + 1];
    for(int i = 0; i < arr.length; i++) {
      arr[i] = new ArrayList<>();
    }
    for(Integer i : map.keySet()) {
      int freq = map.get(i);
      arr[freq].add(i);
    }
    List<Integer> result = new ArrayList<>();
    for(int i = maxFreq; i >= 1; i--) {
      for(Integer j : arr[i]) {
        result.add(j);
      }
      if(result.size() >= k) return result;
    }
    return result;
  }
}

/*
Classic Application of Bucket sort (Counting Sort).
*/
