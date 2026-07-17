// Search in Rotated Sorted Array
//One thing mind this check wherever equality require 
// first select which half mid is .. then calculate 
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<nums[low]){ //right side 
                if(target>nums[mid] && target <= nums[high] ){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }else{// left side
                if(nums[mid]>target && target >= nums[low]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
