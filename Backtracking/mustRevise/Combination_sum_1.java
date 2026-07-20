// idx == candidates.length || target < 0 — catches both "no more candidates to try" and "we overshot the target" before any array access.
// target == 0 — success case, record the combination.
// Otherwise, try picking candidates[idx] again (since you can reuse the same number — that's the "pick" branch staying at idx, not idx+1),
//  then backtrack and try skipping it.


class Solution {

    public void helper(int candidates[],int idx,int target,List<Integer> ls ,List<List<Integer>> ans ){
        if (idx == candidates.length || target < 0) {
            return;
        }
        if(target ==0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        
        ls.add(candidates[idx]);
        helper(candidates,idx,target-candidates[idx],ls,ans);//pick (stay at idx, reuse allowed)
        ls.remove(ls.size()-1);
        helper(candidates,idx+1,target,ls,ans);//not pick
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
         helper(candidates,0,target,new ArrayList<>(),ans);
         return ans;
    }
}
