//Approach 1 : here we know that [1,2,3,4,5,6....] so we need kth missing element so for this .
//we have to just iterate on each element and if element is less that k than k++;
//then when  full iteration finish then finally we return k as ans.

//approach 2 : here we have to think fo like we need range find with low and high so we do binary search for all element and find missing element ,
// then  check with k 
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0,high = arr.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            int missing = arr[mid]-(mid+1);
            if(missing<k)low = mid+1;
            else high = mid-1;
        }
        return low+k;
    }
}
