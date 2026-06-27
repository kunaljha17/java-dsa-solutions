public class fibonacci_memoization{
  public static int fib(int n , int dp[]){
    if (n==0||n==1) {
        return n;
    }
    if (dp[n]!=0) {
        return dp[n];
    }
    dp[n] = fib(n-1, dp) + fib(n-1, dp);
    return dp[n];
    }

    public static void main(String[] args) {
         int n = 6;
         int dp [] = new int[n+1];
         System.out.print(0+" " +1 +" ");
        for(int i=1 ; i<=n;i++){
           System.out.print(fib(i, dp) + " ");
        }

    }
}