// not so good appraoch than two pointer way but better than brute 
// Here i have to use hashset for unique element and another hashset for find target element


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        int n = nums.length;
        for(int i =0;i<n-1;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i +1;j<n;j++){
                int target = -(nums[i]+nums[j]);
                ArrayList<Integer> list = new ArrayList<>();
                if(set.contains(target)){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    Collections.sort(list);
                    if(!s.contains(list)){
                    s.add(list);
                    ans.add(list);
                    }
                }else{
                    set.add(nums[j]);
                }
            }
        }
        return ans;
    }
}
