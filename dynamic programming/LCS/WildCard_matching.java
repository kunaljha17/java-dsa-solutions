package LCS;

public class WildCard_matching {

    public static boolean text_pattern(String S, String P) {
        int n = S.length();
        int m = P.length();
        boolean dp[][] = new boolean[n + 1][m + 1];

        // Initialize dp So mind index with dp n+1 m+1 i =1 j=1
        dp[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            if (P.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else { // when char or ?
                dp[0][i] = false;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }

        // BottomUp
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // case -> ith char == jth char || jth char == ?
                if (S.charAt(i - 1) == P.charAt(j - 1) || P.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (P.charAt(j - 1) == '*') {
                    boolean ignore = dp[i][j - 1];
                    boolean match_with_star = dp[i - 1][j];
                    dp[i][j] = ignore || match_with_star;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        String s = "aaa";
        String p = "a*";

        System.out.println(text_pattern(s, p));

        //Output : true


    }
}
// javac LCS/WildCard_matching.java
// java LCS.WildCard_matching 