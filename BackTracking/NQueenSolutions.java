import java.util.*;

public class NQueenSolutions {
  public static void main(String args[]) {
    int n = 4;
    System.out.println(new Solution().totalNQueens(n));
  }
}
class Solution {
    int count;
    public int totalNQueens(int n) {
      int input[] = new int[n];
      Arrays.fill(input, -1);
      nQueens(input, 0);
      return count;
    }
    private void nQueens(int input[], int row) {
      if(row >= input.length) {
        count++;
        return;
      }
      for(int i = 0; i < input.length; i++) {
        if(isFeasible(input, row, i)) {
          input[row] = i;
          nQueens(input, row + 1);
          input[row] = -1;
        }
      }
    }
    private boolean isFeasible(int input[], int row, int col) {
      for(int i = 0; i < input.length; i++) {
        if(input[i] == col) return false;
        if(input[i] != -1 && input[i] + i == row + col) return false;
        if(input[i] != -1 && input[i] - i == col - row) return false;
      }
      return true;
    }
}
