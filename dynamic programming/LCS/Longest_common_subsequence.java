package LCS;

public class Longest_common_subsequence {
    
    public static int RecurLCS(String str1,String str2,int n,int m){
        if (n==0||m==0) {
            return 0;
        }
        if (str1.charAt(n-1)==str2.charAt(m-1)) {
            return RecurLCS(str1, str2, n-1, m-1) +1;
        }else{
            int ans1 = RecurLCS(str1, str2, n-1, m);
            int ans2 = RecurLCS(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }


    public static int LCS_memoization(String str1,String str2,int n,int m , int dp[][]){
        if (n==0||m==0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n-1)==str2.charAt(m-1)) {
            return dp[n][m] = LCS_memoization(str1, str2, n-1, m-1,dp) +1;
        }else{
            int ans1 = LCS_memoization(str1, str2, n-1, m , dp);
            int ans2 = LCS_memoization(str1, str2, n, m-1 , dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }


    public static int LCS_tab(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = 0;
            }
        }

        //bottom UP
        for(int i=1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
                if (str1.charAt(i-1)==str2.charAt(j-1)) {
                         //(i-1)th str1 and (j-1)th str2 LCS value  and +1 is for current char length count
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{//NOT VALID :_ means ith and jth char of str1 and str2 not match
                                          //ans1      //ans2
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }



    public static void main(String[] args) {
        // String str1 = "abcde";
        // String str2 = "ace";
        // System.out.println(RecurLCS(str1, str2, str1.length(), str2.length()));
        //OUTPUT :- 3


        String str1 = "ABCD";
        String str2 = "ACEB";
        int n =str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j =0;j<m+1;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(LCS_memoization(str1, str2, n, m, dp));
        //OUTPUT :- 2
        
    }
}
// javac LCS/Longest_common_subsequence.java 
// java LCS.Longest_common_subsequence 