import java.util.*;
public class SparseMatrixMul {
  public static void main(String args[]) {
    int A[][] = new int[][]{{-1,0,0},{-1,0,3}};
    int B[][] = new int[][]{{7,0,0},{0,0,0},{0,0,1}};
    long start = System.nanoTime();
    System.out.println(Arrays.deepToString(new Solution().multiply(A,B)));
    long end = System.nanoTime();
    System.out.println("Time:" + (end - start));
    start = System.nanoTime();
    System.out.println(Arrays.deepToString(new Solution().sparseMultiply(A,B)));
    end = System.nanoTime();
    System.out.println("Time:" + (end - start));
  }
}
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
      int m = A.length;
      int n = A[0].length;
      int p = B[0].length;
      int result[][] = new int[m][p];
      for(int i = 0; i < m; i++) {
        for(int j = 0; j < p ; j++) {
          for(int k = 0; k < n; k++) {
            result[i][j] += A[i][k] * B[k][j];
          }
        }
      }
      return result;
    }
    public int[][] sparseMultiply(int A[][], int B[][]) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        int result[][] = new int[m][p];
        for(int i = 0; i < m; i++) {
          for(int k = 0; k < n; k++) {
            if(A[i][k] != 0) {
              for(int j = 0; j < p; j++) {
                result[i][j] += A[i][k] * B[k][j];
              }
            }
          }
        }
        return result;
    }
}
