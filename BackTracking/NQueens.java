import java.util.*;

public class NQueens {
  public static void main(String args[]) {
    int n = 4;
    System.out.println(new Solution().solveNQueens(n));
  }
}
class Solution {
    public List<List<String>> solveNQueens(int n) {
      int input[] = new int[n];
      Arrays.fill(input, -1);
      List<List<String>> list = new ArrayList<List<String>>();
      nQueenSolution(0, input, list);
      return list;
    }
    private void nQueenSolution(int row, int input[], List<List<String>> ans) {
      if(row >= input.length) {
        makeAnswer(input, ans);
        return;
      }
      for(int i = 0; i < input.length; i++) {
        if(feasiblePos(row, i, input)) {
          input[row] = i;
          nQueenSolution(row + 1, input, ans);
          input[row] = -1;
        }
      }
    }

    private void makeAnswer(int input[], List<List<String>> ans) {
      List<String> list = new ArrayList<>();
      StringBuilder buff = new StringBuilder();
      for(int i = 0; i < input.length; i++) {
        buff.append(".");
      }
      for(int i = 0; i < input.length; i++) {
        StringBuilder br = new StringBuilder(buff.toString());
        br.replace(input[i], input[i] + 1, "Q");
        list.add(br.toString());
      }
      ans.add(list);
    }

    private boolean feasiblePos(int row, int col, int input[]) {
      //check feasibility of (row, col)
      for(int i = 0; i < input.length; i++) {
        if(input[i] == col) return false;
        if(input[i] != -1 && input[i] + i == row + col) return false;
        if(input[i] != -1 && input[i] - i == col - row) return false;
      }
      return true;
    }
}
