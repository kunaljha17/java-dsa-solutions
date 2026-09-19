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
(for right rotate)
// First reverse  reverse entire array
//   then revrse reverse first k elements
//   then final reverse remaining n-k elements
(for left rotate)
//  Step 1: reverse first k elements
// Step 2: reverse remaining n-k elements
// Step 3: reverse entire array
    
//here in this way time complexity slightly increae but space complexity is O(1)

