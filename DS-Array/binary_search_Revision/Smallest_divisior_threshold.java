//Approach is simple , we have to first understand the problem ,
//in this we have unsorted array ,but my answer is shortest divisor that has minmum remainder sum ,is less than or equal to thresshold 

//we know that high possible could be array max element , So with taking high max array, and low as 1 and do this 
//do finding by using binary search . there when i get remainder sum is than threshold then ,store this and move so on for finding smallest divisor by doing high =mid -1,if not then low = mid +1


class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            high = Math.max(high,nums[i]);
        }
        int ans = 1;
         
        while(low<=high){
            int mid = low+(high-low)/2;
            int sumDiv = 0;
            for(int num:nums) sumDiv += (int) Math.ceil((double) num / mid);
            if(sumDiv<=threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
