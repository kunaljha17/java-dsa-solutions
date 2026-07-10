 public int[] productExceptSelf(int[] nums) {
        int newArr [] = new int[nums.length];
        int mul = 1;
        int zeroCount = 0;
        int idx = 0;
         for(int i = 0;i<nums.length;i++){
             if(nums[i] ==0){
                zeroCount++;
                idx = i;
                continue;
             }
                mul *= nums[i];
         }
        if(zeroCount ==1){
            newArr[idx] = mul;
            return newArr;
        }
        else if(zeroCount>1){
            return newArr;
        }else{
            for(int i = 0;i<nums.length;i++){
                newArr[i] = mul / nums[i];
            }
         }
         return newArr;



//Approach 2 

    public int[] productExceptSelf(int[] nums) {
        int newArr [] = new int[nums.length];
        int mul = 1;
        int zeroCount = 0;
        int idx = 0;
         for(int i = 0;i<nums.length;i++){
             if(nums[i] ==0){
                zeroCount++;
                idx = i;
                continue;
             }
             mul *= nums[i];
         }
        if(zeroCount ==1){
            newArr[idx] = mul;
            return newArr;
        }
        else if(zeroCount>1){
            return newArr;
        }else{
            newArr[0] = 1;
           for (int i = 1; i < nums.length; i++) { //prefix 
                newArr[i] = newArr[i - 1] * nums[i - 1]; //,here no zeros in nums
                }
           int suffix = 1;
           for(int i = nums.length-2;i>=0;i--){//suffix
             suffix =  suffix*nums[i+1];
             newArr[i] = newArr[i]*suffix; //for i = nums.length-1 no suffix require 
          }
    }
    return newArr; 
  }
