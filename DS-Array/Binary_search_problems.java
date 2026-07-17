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




// Single Element in a Sorted Array
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
// mid is even
// Yes → pairing is still normal.
// The single element must be to the right.

// No → the pairing has already broken.
// The single element is at mid or to the left.



class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}

