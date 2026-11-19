//approach is similar to binary Sum equal to k problem

//In this i simiply do as previous (nums,k) -(nums,k-1) technique
//In this i think that if i get <=k and <=k-1 then 
//i do (<=k) - (<=k-1) == gives only k odd number subarray count

// So i have to write code for <=k count code 


class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numSubarrays(nums,k)-numSubarrays(nums,k-1);
    }


    public int numSubarrays(int[] nums,int k){
        int l =0,r = 0;
        int count = 0;
        while(r<nums.length){
            if(nums[r]%2==1)k--;
            while(k<0){
                if(nums[l]%2==1) k++;
                l++;
            }
            count +=r-l+1;
            r++;
        }
        return count;
    }
}
