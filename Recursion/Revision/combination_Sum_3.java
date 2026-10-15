// here i know that i have to pick value under 1 to 9 and also i have too mind this that duplicate not allowed So ,
// modify combination sum2 to this 
// Here i have also add base case on number of k numbers allowed and sum equal to n 

class Solution {

    public void f(int k, int n, List<Integer> ls, List<List<Integer>> ans, int num) {
        if (n < 0 || k < 0)
            return;
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = num;i<10;i++){
        ls.add(i);
        f(k - 1, n - i, ls, ans, i + 1);
        ls.remove(ls.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        f(k, n, new ArrayList<>(), ans, 1);
        return ans;

    }
}
