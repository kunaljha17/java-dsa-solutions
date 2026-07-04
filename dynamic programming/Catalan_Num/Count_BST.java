public class Count_BST {

    public static int BST_count(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] =1;
        for(int i =2;i<n+1;i++){
            for(int j =0 ;j<=i-1;j++){
                //Ci -> BSt (i nodes) -> dp[i]
                int leftCount = dp[j];
                int rightCount = dp[i-j-1];
                dp[i] += leftCount * rightCount;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int nodes[] = {10,20,30,40,50};
       System.out.println( BST_count(nodes.length));
    }
}
