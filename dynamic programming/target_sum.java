public class target_sum {

    public static boolean Tab_targetSum(int num[],int sum){
        int n = num.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }
        for(int i =1;i<n+1;i++){
            for(int j =1;j<sum+1;j++){
                if (j>=num[i-1]&&dp[i-1][j-num[i-1]]) {
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int num [] = {4,2,7,1,3};
        int sum =10;
        System.out.println(Tab_targetSum(num, sum));
    }
}
