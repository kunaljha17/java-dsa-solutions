package LCS;

public class Edit_distance {

    public static int editDist_Tab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        // initialization
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m+1; j++) {
            dp[0][j] = j;
        }

        // bottomUp
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        System.out.println(editDist_Tab(word1, word2));
        //Output is 5


    }
}

//javac LCS/Edit_distance.java
//java LCS.Edit_distance
