//Approach this is similar problem like banquets problem , here first think for range where possible ans could always would be 
//first i think for minimum of array but after that i think that , there is so many package so bag could be max of weights array 
// So low is max of weights array and 
//high possible could be when all package could be possible ship in one day ,So capacity high is Sum of all and also if capacity is more than sum of all package weight 
//then same package would ship in one day . atleast one day take to ship package.

//Then next i have to think for possible capacity could be , by doing normal iteration and check for does this exceed curr Capacity or not and count day

class Solution {

    public boolean possible(int[] weights, int days, int capacity) {
         int currWeight = 0;
         int day = 1;
         for(int weight:weights){
            if(currWeight + weight>capacity){
                day++;
                currWeight = 0;
            }
            currWeight += weight;
            if(day>days) return false;
         }
         return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
