//In this in type of standard sliding window problem , here in this we know that we have 
// wanted exactly number of time something in each subarray , this Type we use 
// k - (k-1) time ans So by this we get exactly k time ans .
//This is hard level problem but i know the concept how to track integer with frequecy . So 
//This exact problem i solved previously . named something like . Count subarrays that have atmost k different character



class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return numSubarray(nums,k) - numSubarray(nums,k-1);
    }

    public int numSubarray(int []nums , int k){
        if(k<=0)return 0;
        int l =0,r=0;

        int count =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0)map.remove(nums[l]);
                l++;
            }
            count +=(r-l+1);
            r++;
        }
        return count;
    }
}


