public class HammingDistance {
  public static void main(String args[]) {
    int x = 3;
    int y = 4;
    System.out.println(new Solution().hammingDistance(x,y));
  }
}
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while(xor > 0) {
            count += xor & 1;
            xor >>= 1;
        }
        return count;
    }
}
