// Guess the maximum products per store (mid) → Calculate how many stores 
// are needed using ceil(quantity / mid) → If stores needed ≤ available stores,
// try a smaller maximum; otherwise, increase it.

// Input: n = 6, quantities = [11,6]
// Output: 3 : max(2, 3, 3, 3, 3, 3) = 3


class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i = 0;i<quantities.length;i++){
            high = Math.max(high,quantities[i]);
        }
        int ans = 0;
        while(low<=high){
            int mid = low + (high -low)/2;
            int store = 0;
            
            for( int q : quantities){
                store += (q + mid - 1) / mid; ;
            }
            if(store <=n){
                ans  = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
         return ans;
    }
}
