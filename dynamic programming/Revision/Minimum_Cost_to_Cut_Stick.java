//Approach 1 by memoization

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] points = new int[m + 2];
        points[0] = 0;
        points[m + 1] = n;
        for (int i = 0; i < m; i++) points[i + 1] = cuts[i];
        Arrays.sort(points);

        Integer[][] memo = new Integer[points.length][points.length];
        return solve(points, 0, points.length - 1, memo);
    }

    private int solve(int[] points, int i, int j, Integer[][] memo) {
        if (j - i <= 1) return 0;

        if (memo[i][j] != null) return memo[i][j];

        int best = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = points[j] - points[i]
                      + solve(points, i, k, memo)
                      + solve(points, k, j, memo);
            best = Math.min(best, cost);
        }

        memo[i][j] = best;
        return best;
    }
}

//Approach 2 by tabulation


class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] points = new int[m + 2];
        points[0] = 0;
        points[m + 1] = n;
        for (int i = 0; i < m; i++) {
            points[i + 1] = cuts[i];
        }
        Arrays.sort(points);

        int len = points.length;
        int[][] dp = new int[len][len];

        // gap = number of steps between i and j in the points array
        for (int gap = 2; gap < len; gap++) {
            for (int i = 0; i + gap < len; i++) {
                int j = i + gap;
                int best = Integer.MAX_VALUE;

                // try every cut point k between i and j as the FIRST cut
                for (int k = i + 1; k < j; k++) {
                    int cost = points[j] - points[i]   // cost of this segment right now
                              + dp[i][k]                // cost of left part
                              + dp[k][j];                // cost of right part
                    best = Math.min(best, cost);
                }

                dp[i][j] = best;
            }
        }

        return dp[0][len - 1];
    }
}
