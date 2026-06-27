public class recrKnapsack0_1 {

    public static int knapsack(int val[],int wt[],int W,int n){
        if (W==0||n==0) {
            return 0;
        }
        if (W>=wt[n-1]) {
            int include = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1);
            int exclude = knapsack(val, wt, W, n-1);
            int maxProfit = Math.max(include, exclude);
            return maxProfit;
        }else{
            return knapsack(val, wt, W, n-1);
        }
    }

    public static void main(String[] args) {
        int val[]= {15,14,10,45,30};
        int wt[] = {2, 5,1,3,4};
        int W=7;
        System.out.println(knapsack(val, wt, W, val.length));
    }
}
