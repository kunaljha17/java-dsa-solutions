//Approah by dp
//int this we know 3 possible case
//case 1 jb s ka ith char p ke jth char se match ho jaye  yaa   p ka jth char ? hai tbb previous value assign kr denga i -1 ,j-1                        //match     //ignore
//case 2 jb p ka jth char * hai tb esme do possible value ho skta hai phela star * ko match krwa de char se ya dusra ki star * ko ignore kr de .. esme (i-1)(j) or (i)(j-1)
//case 3 else me i j th pe false


class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(),m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];

        //base case
        dp[0][0] = true;
        for(int i=1;i<m+1;i++) if(p.charAt(i-1)=='*') dp[0][i] = dp[0][i-1];
        for(int i=1;i<n+1;i++) dp[i][0] = false;

        for(int i=1;i<n+1;i++){
            for(int j =1;j<m+1;j++){                                            //shift char value
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?') dp[i][j] = dp[i-1][j-1];
                                                      //match *   ||  //ignore *
                else if(p.charAt(j-1)=='*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else dp[i][j] = false;
            }
        }
    return dp[n][m];
    }
}
