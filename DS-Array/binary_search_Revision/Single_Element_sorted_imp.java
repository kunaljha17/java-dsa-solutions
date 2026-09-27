//  nums = [1,1,2,3,3,4,4,8,8]
    // from single element , we compare left half (even , odd)
    //   from single right we compare (odd , even) <-- else part 
    //   //this when we statify our thought ,eliminate left or right half for no more search space 



class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n ==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1, high = n-2;
        while(low<=high){
            int mid = low +(high - low)/2;
            
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){ // this is actualy my ans val
                return nums[mid];
            }

            if((mid %2==0 && nums[mid] == nums[mid+1]) || (mid%2 ==1 && nums[mid] == nums[mid-1])){ //eliminate left half
                low = mid+1;
            }else{ //eliminate right half
                high = mid-1;
            }
        }
        return -1;
    }
}
