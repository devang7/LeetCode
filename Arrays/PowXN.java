public class PowXN {
  public static void main(String args[]) {
    double x = 5;
    int n = -3;
    System.out.println(new Solution().myPow(x,n));
  }
}
class Solution {
    public double myPow(double x, int n) {
      if(n == 0) return 1;
      if(n == 1) return x;
      double temp = myPow(x, n/2);
      if(n > 0) {
        if(n % 2 == 0) return temp*temp;
        else return x*temp*temp;
      } else {
        if(n % 2 == 0) return temp*temp;
        else return (temp*temp) / x;
      }
    }
}
