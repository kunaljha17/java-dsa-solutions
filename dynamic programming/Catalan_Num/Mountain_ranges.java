public class Mountain_ranges {
    
    public static int Mountain_Possible_count(int n_pair){
        int dp[] = new int[n_pair+1];

        dp[0]= 1;
        dp[1] =1;
        
        for(int i =2;i<n_pair+1;i++){
            for(int j =0;j<=i-1;j++){
                int inside_mount = dp[j];
                int outside_mount = dp[i-j-1];

                dp[i] += inside_mount*outside_mount;
            }
        }
        return dp[n_pair];
    }
    
    public static void main(String[] args) {
        int n_pair = 4;
        System.out.println(Mountain_Possible_count(n_pair));
    }
}
