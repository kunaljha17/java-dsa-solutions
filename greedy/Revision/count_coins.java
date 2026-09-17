//here it simple greedy coins problem
// in this we have to use greedy approch first take high coin val

class Solution {
    public int findMin(int n) {
        int count =0;
        int[]coins = {1,2,5,10};
        for(int i=coins.length-1;i>=0;i--){
            if(coins[i]<=n){
                while(coins[i]<=n){ // until amount is greater than current coin
                    count++;
                    n -=coins[i];
                }
            }
        }
        return count;
    }
}
