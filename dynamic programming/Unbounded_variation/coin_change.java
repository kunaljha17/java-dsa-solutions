// package Unbounded_variation;

public class coin_change {

    public static int coinChangeTab(int coin[], int sum){
        int n = coin.length;
        int dp[][] = new int[n+1][sum+1];

        //Base case initialization
        for(int i =0;i<n+1;i++){
            dp[i][0] = 1;
        }
        for(int i =1 ;i<sum+1;i++){
            dp[0][i] = 0;
        }
        
        for(int i =1;i<n+1;i++){
            for(int j =1 ; j<sum+1;j++){
                if (j>=coin[i-1]) { //Valid 
                                // again include current coins so i not i-1
                                //include ways           //exclude ways
                    dp[i][j] = dp[i][j-coin[i-1]] + dp[i-1][j];
                }else{// NOt valid 
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {

        int coins[] = {1,2,3};
        int sum = 4;
        System.out.println(coinChangeTab(coins, sum));
        //OUTPUT :- 4

        
    }
}
