package Matrix_chain_multiplication;

import java.util.Arrays;

class mcm_memoization {

    public static int mcm(int arr[], int i, int j , int dp[][]){
        if (i==j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        
        for(int k = i;k<= j-1;k++){
            int set1_cost = mcm(arr, i, k, dp);
            int set2_cost = mcm(arr, k+1, j, dp);

            int both_set_cost = arr[i-1] * arr[k]*arr[j];

            int finalcost = set1_cost + set2_cost +both_set_cost;
            ans = Math.min(ans, finalcost);
        }

        return dp[i][j] = ans; // store (i to j)th matrix minimum cost
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
         int n = arr.length;
        int dp[][] = new int[n][n];

        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(mcm(arr, 1, arr.length-1 , dp));

        //OUTPUT : - 30
    }
     
}

//javac Matrix_chain_multiplication/mcm_memoization.java
//java Matrix_chain_multiplication.mcm_memoization