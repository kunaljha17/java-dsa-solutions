//first sort array after sort i can easily handle duplicates
//run loop for each store in list also each list should subset so stroe in ans list
//also backtrack happen when one sort of subset finished.


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,ls,ans);
        return ans;
    }
    public void backtrack(int nums[],  int idx ,List<Integer> ls, List<List<Integer>> ans){
        
        if(idx<nums.length) ans.add(new ArrayList<>(ls));
        if(idx == nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i =idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;

            ls.add(nums[i]);
            backtrack(nums,i+1,ls,ans);
            ls.remove(ls.size()-1);
        }
    }


}
