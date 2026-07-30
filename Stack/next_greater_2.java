 //i make stack and array result
// then fill initially filled with -1 then
// make stack 2n-1 time loop run minimum if nums is 5 then i<9 check this .. 
// i push into stack i only if i<n after comparing i
// remove top of stack element ...






class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n-1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
}
