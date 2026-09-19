//two approach here ,
// first approach is like
// save element upto k from right in temp array
//then shift right from 0 to n-k to -> k to n
//then put temp store elements from 0 to k of main nums array

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int noOfRot = k%n;
        int[] temp = new int[noOfRot];
         
        for(int i = 0;i<noOfRot;i++) temp[i] = nums[n-noOfRot+i];

        for(int i = 0;i<n-noOfRot;i++){
            nums[n-i-1] = nums[n-noOfRot-1-i];
        }
        for(int i=0;i<noOfRot;i++){
            nums[i] = temp[i];
        }
    }
}
//O(n+k) time complexity
//(k) space complexity

//aprroach two is 

// First reverse 0 to kth element (0 ,k)
//   then revrse k to nth element (k,n)
//   then final revrse all to get desire array (0,n)

//here in this way time complexity slightly increae but space complexity is O(1)

