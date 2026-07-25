// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for(int i = nums2.length-1;i>=0;i--){
            while(!s.isEmpty() && nums2[i]>=nums2[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                map.put(nums2[i],-1);
            }
            else{
                map.put(nums2[i],nums2[s.peek()]);
            }
            s.push(i);
        }
        int ans[] = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
