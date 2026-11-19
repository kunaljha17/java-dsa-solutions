//Approach is simple , in this We have to find Subarrays with Sum equals to goal K.
// In this we have to think like this , we have to find subarray (nums, goal) - (nums ,goal) 

// Here So , find and count total subarray 

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarray(nums,goal) - numSubarray(nums,goal-1);
    }

    public int numSubarray(int[]nums,int goal){
        if(goal<0)return 0;
        int l =0,r= 0;
        int count = 0;
        int sum = 0;
        while(r<nums.length){
            sum += nums[r];
            while(  sum>goal){
                sum -=nums[l];
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}
