package Matrix_chain_multiplication;

public class mcm_tabulation {

    public static int mcm(int arr[]) {

        int n = arr.length;

        // dp[i][j] = Minimum cost to multiply matrices from Ai to Aj
        int dp[][] = new int[n][n];

        // Base Case:
        // Cost of multiplying a single matrix is 0.
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // len = number of matrices in the current chain.
        // First solve chains of length 2,
        // then length 3,
        // then length 4...
        // This ensures smaller subproblems are already solved.
        for (int len = 2; len <= n - 1; len++) {

            // i = starting matrix of the current chain.
            // Example:
            // len = 2  -> (A1,A2), (A2,A3), (A3,A4)
            // len = 3  -> (A1,A2,A3), (A2,A3,A4)
            for (int i = 1; i <= n - len; i++) {

                // j = ending matrix of the current chain.
                // Formula:
                // number of matrices = j - i + 1 = len
                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible place to split the chain.
                // Split between Ak and A(k+1).
                for (int k = i; k <= j - 1; k++) {

                    // Cost of left subproblem (Ai...Ak)
                    int cost1 = dp[i][k];

                    // Cost of right subproblem (A(k+1)...Aj)
                    int cost2 = dp[k + 1][j];

                    // Cost of multiplying the two resulting matrices.
                    // Left matrix dimensions:
                    // arr[i-1] × arr[k]
                    //
                    // Right matrix dimensions:
                    // arr[k] × arr[j]
                    //
                    // Multiplication cost:
                    // arr[i-1] * arr[k] * arr[j]
                    int mergeCost = arr[i - 1] * arr[k] * arr[j];

                    // Store the minimum cost among all possible splits.
                    dp[i][j] = Math.min(dp[i][j],
                                        cost1 + cost2 + mergeCost);
                }
            }
        }

        // Minimum cost to multiply the entire chain A1...A(n-1)
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        System.out.println(mcm(arr)); // Output: 30
    }
}
// javac Matrix_chain_multiplication/mcm_tabulation.java
// java Matrix_chain_multiplication.mcm_tabulation




//kj😉