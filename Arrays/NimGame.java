public class NimGame {
  public static void main(String args[]) {
    int n = 5;
    System.out.println(new Solution().canWinNim(n));
  }
}
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}

/*
=> Only has 1 heap. Player can take 1,2,3 at each turn. So if you reach 4 -> 1,2,3
If you reach 8 -> 7,6,5
Assuming both play optimally, if you are at a stage where n % 4 == 0 you are never going to win. 
*/
