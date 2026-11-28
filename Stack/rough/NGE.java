class Solution {
    public int[] nextGreaterElement(int[] nums1 ) {
      int[] num2 = new int[nums1.length];
      Stack<Integer> s = new Stack<>();

      for(int i=nums1.length-1;i>=0;i--){
        while(!s.isEmpty() && nums1[i]>=nums1[s.peek()]){
          s.pop();
        }
        if(s.isEmpty()){
          num2[i] = -1;
        }else{
          num2[i] = nums1[s.peek()];
        }
        s.push(i);
      }
      return num2;
    }
}

// here num2 is storing each element next greater element
