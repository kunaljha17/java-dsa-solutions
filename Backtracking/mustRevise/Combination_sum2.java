// at each recursion level you try each candidate from idx onward as the next element, 
// skip duplicates at the same level, and move to i+1 (not idx+1) so each element is used at most once

// Sort array only for Combination Sum II (40).
// Base Case: target == 0 → ans.add(new ArrayList<>(list)); return;
// Invalid Case: target < 0 or idx == n → return.
// Choose → Recurse → Undo (add → helper → remove).
// 39: Reuse allowed → recursive call with helper(i, ...).
// 40: Reuse not allowed → recursive call with helper(i + 1, ...).
// Loop: for (int i = idx; i < n; i++).
// Pruning: if (arr[i] > target) break; (array is sorted).
// Skip duplicates (40): if (i > idx && arr[i] == arr[i - 1]) continue;.
// Remember: 39 = Reuse (i), 40 = No Reuse (i+1) + Sort + Duplicate Skip (i > idx).


class Solution {
     public void helper(int candidates[],int idx,int target,List<Integer> ls ,List<List<Integer>> ans ){
        if(target ==0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = idx;i<candidates.length;i++){

        if(i>idx && candidates[i] ==candidates[i-1]) continue;
        if(candidates[i]>target) break;

        ls.add(candidates[i]);
        helper(candidates, i + 1, target - candidates[i], ls, ans);
        ls.remove(ls.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> ans = new ArrayList<>();
         Arrays.sort(candidates);
         helper(candidates,0,target,new ArrayList<>(),ans);
         return ans;
    }
}
