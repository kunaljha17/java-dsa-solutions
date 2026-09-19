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


//aprroach two is 

// First reverse 0 to kth element
//   then revrse k to nth element 
//   then final revrse all to get desire array

