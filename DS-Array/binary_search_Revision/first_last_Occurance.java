//Approach similar to binary search , but we have one thing to ,that we have seperately find lower bound and upper bound as we know about this 
//then check validity of lower bound then upper bound 
// we have add {lower bound , upper bound -1}; so cover range properly


class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target) return true;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            else if(nums[mid]<nums[low]){//right
                if(nums[mid]<target && nums[high]>=target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }else{ //left
                if(nums[mid]>target && nums[low]<=target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return false;
    }
}
