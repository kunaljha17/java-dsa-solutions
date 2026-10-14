//This is appproach in combination sum . One common approach is to sort the array and use a loop.
// Remember: i > idx skips duplicates at the same recursion level, not duplicates at different levels.

// Problem	         |    What changes in your code?
// Subsets I	  ->     |   Store every current list
// Subsets II  	->   |    Add sorting + duplicate skipping
// Combination Sum II -> | Add sorting + duplicate skipping + target condition


//Subset 1

void solve(int idx, int[] nums, List<Integer> ds) {
    if (idx == nums.length) {
        ans.add(new ArrayList<>(ds));
        return;
    }

    // Pick
    ds.add(nums[idx]);
    solve(idx + 1, nums, ds);
    ds.remove(ds.size() - 1);

    // Not pick
    solve(idx + 1, nums, ds);
}

//Alternative 
class Solution {

    public void f(int idx, int[] nums, ArrayList<Integer> ls, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ls));
        for (int i = idx; i < nums.length; i++) {
            ls.add(nums[i]);
            f(i + 1, nums, ls, ans);
            ls.remove(ls.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}


//Subset 2
 class Solution {

    public void f(int idx, int[] nums, ArrayList<Integer> ls, List<List<Integer>> ans) {
        if(idx<nums.length) ans.add(new ArrayList<>(ls));
        if(idx == nums.length){
        ans.add(new ArrayList<>(ls));
        return;
        }
        for (int i = idx; i < nums.length; i++) {
            if(i>idx && nums[i]==nums[i-1]) continue;

            ls.add(nums[i]);
            f(i + 1, nums, ls, ans);
            ls.remove(ls.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(0,nums,new ArrayList<>(),ans);
        return ans;
    }
}


//Combination sum 1
class Solution {

    public void f(int idx,int[]candidates , int target , List<List<Integer>> ans , List<Integer> ls){
        if(idx >=candidates.length || target<0) return;

        if(target == 0){
            ans.add(new ArrayList<>(ls));
            return;
        }

        //pick
        ls.add(candidates[idx]);
        f(idx,candidates,target-candidates[idx],ans,ls);
        ls.remove(ls.size()-1);
        f(idx+1,candidates,target,ans,ls); //not pick
   
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}

//Combination Sum 2

class Solution {
    public void helper(int candidates[], int idx, int target, List<Integer> ls, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {

            if (i > idx && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;

            ls.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], ls, ans);
            ls.remove(ls.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
}


