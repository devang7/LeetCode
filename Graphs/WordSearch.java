public class WordSearch {
  public static void main(String args[]) {
    char board[][] = new char[][]{"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
    String word = "ABCC";
    System.out.println(new Solution().exist(board, word));
  }
}
class Solution {
  public boolean exist(char board[][], String word) {
    char w[] = word.toCharArray();
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        if(board[i][j] == w[0]) {
          if(dfs(w, 1, board, i, j)) return true;
        }
      }
    }
    return false;
  }
  public boolean dfs(char w[], int start, char board[][], int a, int b) {
    if(start >= w.length) return true;
    char prev = board[a][b];
    board[a][b] = '*';
    boolean a1 = a - 1 >= 0 && board[a-1][b] == w[start] && dfs(w, start + 1, board, a - 1, b);
    boolean a2 = a + 1 < board.length && board[a + 1][b] == w[start] && dfs(w, start + 1, board, a + 1, b);
    boolean a3 = b - 1 >= 0 && board[a][b-1] == w[start] && dfs(w, start + 1, board, a, b - 1);
    boolean a4 = b + 1 < board.length && board[a][b+1] == w[start] && dfs(w, start + 1, board, a, b + 1);
    if(a1 || a2 || a3 || a4) return true;
    board[a][b] = prev;
    return false;
  }
}
