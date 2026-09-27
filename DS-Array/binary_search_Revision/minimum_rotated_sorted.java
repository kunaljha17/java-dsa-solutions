//Approach is like , we first think that one varible need to store every mid minimum ,
// first think for how i find minimum , so first think that . i have to move toward minimum val only nothing where minimum is psossible 

//so , we have first check does our mid is located in left or right , if right then we know that sorted so we move 
//high = mid -1 , so for finding minimum ,
//if mid is in left , we know that when left then we have one edge case that , when mid is less that high then high = mid -1 , if not low = mid +1 ,
//So we jump to right part with this .. 

class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            min = Math.min(min,nums[mid]);
            if(nums[mid]<nums[low]){ //right
                  high = mid-1;
            }else{ //left
                if(nums[mid]<nums[high]) high = mid -1; // this is when actual minimum is in left 
                else low = mid+1; //jump to right we assume to find mid there 
            }
        }
        return min;
    }
}




//alternative if else works 
if (nums[mid] > nums[high]) {
                // Minimum is in right half
                low = mid + 1;
            } else {
                // Minimum can be mid or left half
                high = mid - 1;
            }
