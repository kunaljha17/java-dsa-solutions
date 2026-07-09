//Approach for this is :
// Find the pivot. pivot means nums[i] <nums[i+1]
// Find the next greater element from the right. pivot<nums[i] from right to left first occurence
// Swap them.
// Reverse the suffix. reverse after pivot element 


class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivt = -1;
        int pivtIdx = n-1;

        for(int i = n-2;i>=0;i--){
            pivtIdx--;
            if(nums[i]<nums[i+1]){
                pivt = nums[i];
                break;
            }
        }

        if(pivt == -1){
            //reverse array
            int st= 0;
            int en = n-1;
            while(st<en){
                int temp = nums[st];
                nums[st] = nums[en];
                nums[en] = temp;
                st++;
                en--;
            }
            return;
        }

        for(int i = n-1;i>pivtIdx ;i--){
            if(pivt<nums[i]){
                int temp = nums[i];
                nums[i] = nums[pivtIdx];
                nums[pivtIdx] = temp;
                break;
            }
        }

        int left = pivtIdx+1;
        int right = n-1;
         while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
         }
    }
}
