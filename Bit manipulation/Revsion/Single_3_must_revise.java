//Here approach is bucket way 

//first take xor of all store in one xor 
//then , we know , we have two distict number to find that is in xor stored...
//So for seperating this .. first we have to find first right most bit in xor that is set bit...
//So for this we calculate rightBit  , by take xorr with (xor-1) then final and operation two get rightmost bit only ..

// then we know first both number have one bit is differet So , take bucket1 and bucket2 ,
//store in there . bucket1 have that rightmost bit is set and bucket2 have rightmost bit is different

//So on ....
// at the end we have ans

class Solution {
    public int[] singleNumber(int[] nums) {
        long xor =0;
        for(int num :nums){
            xor = xor^num;
        }
        long rightBit =  (xor^(xor-1))&xor;

        int bucket1 = 0,bucket2 = 0;
        for(int num:nums){
            if((rightBit & num) == 0){
                bucket1 = bucket1^num;
            }else{
                bucket2 = bucket2^num;
            }
        }
        return new int[]{bucket1,bucket2};
    }
}
