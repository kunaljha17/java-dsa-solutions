//Simiply here we applies previous concept of pick or not pick ,
// and in this we have unlimited number time choose same number candidates ,
//Base case is important , we have to handle index and target both 
// do dry run , make tree 


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
