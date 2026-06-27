

public class memoization_knapsack {

        public static int knapsack(int val[],int wt[],int W,int n , int dp[][]){
        if (W==0||n==0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (W>=wt[n-1]) {
            int include = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1 ,dp);
            int exclude = knapsack(val, wt, W, n-1,dp);
            int maxProfit = Math.max(include, exclude);
            dp[n][W]=maxProfit;
            return maxProfit;
        }else{
            dp[n][W] = knapsack(val, wt, W, n-1,dp);
            return dp[n][W];
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W= 7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0;i<dp.length;i++){
            for(int j =0 ;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(val, wt, W, val.length, dp));
        printDp.print(dp);
        
    }
}

//Output 
/*
75

-1 -1 -1 -1 -1 -1 -1 -1 
-1 0 15 15 15 -1 15 15 
-1 -1 15 15 15 -1 15 29 
-1 -1 -1 25 25 -1 -1 29 
-1 -1 -1 45 -1 -1 -1 70 
-1 -1 -1 -1 -1 -1 -1 75 
 */