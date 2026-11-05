//Approach by checking bit that is set then add idx nums val into list
//At the end return ans 


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int subsets = 1 << n;
        for (int k = 0; k < subsets; k++) {
            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (((k >> i) & 1) == 1) {
                    ls.add(nums[i]);
                }
            }
            ans.add(new ArrayList(ls));
        }
        return ans;
    }
}
