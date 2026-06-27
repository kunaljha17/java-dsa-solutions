public class tabulation_kanpsack {
    public static int tabKnapsack(int val[], int wt[], int W , int dp[][]){
        int n = val.length;
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=0;
        }
        
        for(int i = 1 ;i<n+1;i++){
            for(int j = 1;j<W+1;j++){
                 int v = val[i-1];
                 int w = wt[i-1];
                 if (j>=w) {
                    //include
                    int include = v + dp[i-1][j-w];
                    //exclude
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                 }else{
                    dp[i][j]  = dp[i-1][j];
                 }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W= 7;
        int dp[][] = new int[val.length+1][W+1];

        System.out.println(tabKnapsack(val, wt, W, dp));
        System.out.println();
        printDp.print(dp);
    }
}
//Output dry run and verify
/*
75

0 0 0 0 0 0 0 0 
0 0 15 15 15 15 15 15 
0 0 15 15 15 15 15 29 
0 10 15 25 25 25 25 29 
0 10 15 45 55 60 70 70 
0 10 15 45 55 60 70 75  
*/