//Approach 1 (most optimal approach)
// Here we use 2 bucket method , store num in one if that num is not in two 
//same store num in two if not in one ..
//Mujhe single number dekhna hai .. at the end we have our Single number in ones .. because ...this num not comes again .. so not store in two bucket


class Solution {
    public int singleNumber(int[] nums) {
         int ones = 0,twos =0;
         for(int num:nums){
            ones = (ones^num)&~twos;
            twos = (twos^num)&~ones;
         }
         return ones;
    }
}



//Approach 2 

//this method is also optimal one . here we count set bit in ith position then , at the end we check does modulo with 3 is 0 or not ,
// if not 0 then we set that bit in our ans 
// here we have O(N)*32 tc

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
               if (((num >> i) & 1) == 1) {
                    sum++;
             }
            }
            if (sum % 3 != 0) {
                result = result | (1 << i);
            }
        }


        return result;
    }
}
