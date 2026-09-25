//Approach is simple by using hashSet 
//first add al element then do check that curr element is exist in map or not , if curr element -1 not exist then directly assume that this is starting 
//element then do check and increase count 

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums) hs.add(num);

        int longest = 1;
        
         for(int num:hs){
            if(!hs.contains(num-1)){
                int currNum = num;
                int count = 1;
                while(hs.contains(currNum+1)){
                    count++;
                    currNum++;
                }
                longest = Math.max(longest,count);
            }

        }
        return longest;
    }
}
