package Matrix_chain_multiplication;

public class mcm_recursion {

    public static int mcm(int arr[], int i, int j) {
        if (i == j) {//Single matrix
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            int set1_cost = mcm(arr, i, k); // result matrix = arr[i-1] x arr [k]
            int set2_cost = mcm(arr, k + 1, j);// result matrix = arr[k] x arr[j]
            int both_set_1_2_cost = arr[i - 1] * arr[k] * arr[j];

            int final_cost = set1_cost + set2_cost + both_set_1_2_cost;
            ans = Math.min(ans, final_cost);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        System.out.println(mcm(arr, 1, arr.length-1));

        //OUTPUT: - 30
    }
}
//javac Matrix_chain_multiplication/mcm_recursion.java
//java Matrix_chain_multiplication.mcm_recursion
