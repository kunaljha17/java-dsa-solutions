// In this i first think that this problem looks like variation of lcs 
//So i do next try possible logic for that . i already know how normal LCS works 
// so i try to put this on that with string reverse 
// i do first on my notebook dry run then i find that i am avail to get correct ans . 

// so i write this code 

class Solution {

    public int Lcs(String s , String s2){
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] +1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder newStr = new StringBuilder("");
        for(int i =s.length()-1;i>=0;i--){
            newStr.append(s.charAt(i));
        }
        return Lcs(s,newStr.toString());
    }
}
