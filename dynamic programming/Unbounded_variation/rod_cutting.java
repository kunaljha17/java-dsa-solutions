// package Unbonded_variation;

public class rod_cutting{

    public static int RodCutTab(int prices[],int pieces[],int totRod){
        int dp[][] = new int[prices.length+1][totRod+1];
        //initialization done in java automatically with 0 to fill all boxss of dp[][]

        //bottom up
        for(int i =1;i<prices.length+1;i++){ // i -> tell about number of pieces
            for(int j =1;j<totRod+1;j++){// j tells about allow rod length 
                if (pieces[i-1]<=j) {  //VALID 
                                             //include ith piece             //exclude ith piece
                    dp[i][j] = Math.max(prices[i-1]+dp[i][j-pieces[i-1]], dp[i-1][j]);// dp[][] stores maximum profit with price
                }else{//NOT VALID 
                    dp[i][j] = dp[i-1][j]; //ONLY EXCLUDE ith piece
                }
            }
        }
        return dp[prices.length][totRod];
    }
    public static void main(String[] args) {
        int pieces[] = {1,2,3,4,5,6,7,8};
        int prices[] = {1,5,8,9,10,17,17,20};
        int totRod = 8;
        System.out.println(RodCutTab(prices, pieces, totRod));
    }
}

// 22 output