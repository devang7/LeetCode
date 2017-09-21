public class Search2DMatrix {
  public static void main(String args[]) {
    int matrix[][] = new int[][]{{1,4,7,11},{2,5,8,12},{3,6,9,16},{10,13,14,17}};
    int target = 5;
    System.out.println(new Solution().searchMatrix(matrix, target));
  }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int data) {
      int m = matrix.length;
      int n = matrix[0].length;

      int i = 0;
      int j = n - 1;

      while(i < m && j >= 0) {
        if(data == matrix[i][j])
          return true;
        if(data < matrix[i][j]) {
          j--;
        } else {
          i++;
        }
      }
      return false;
    }
}
/*
=> Observations: If we are (i,j) then (i,j-1) will be min and (i+1,j) would be max around the neighbours.
*/
