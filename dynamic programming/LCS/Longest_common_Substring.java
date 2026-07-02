package LCS;

public class Longest_common_Substring {

    public static int LCSubstring_Tab(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i =0;i<n+1;i++){
            dp[i][0] =0;
        }
        for(int j =0;j<m+1;j++){
            dp[0][j] = 0;
        }
        int ans = 0;

        //bottom Up
        for(int i =1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
                if (str1.charAt(i-1)==str2.charAt(j-1)) { // Same ith and jth char in str1 and str2 :: SO, VALID
                        //previous ith and jth LCS value and 1 for current char 
                    dp[i][j] = dp[i-1][j-1] +1;
                    //by comparing current length with previous max length ...store in ans variable 
                    ans = Math.max(ans, dp[i][j]); //This is because here length get 0 when different char .. by this longest length could be inside DP array somewhere
                }else{//NOT Valid means ith and jth  diff character  
                    dp[i][j] = 0; // So , here length for different char is 0. rest length here .
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
