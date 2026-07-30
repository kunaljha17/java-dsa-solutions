class Solution {
 
    public void helper(Stack<Integer> stack ,int curr){
        if(stack.isEmpty() || stack.peek()<=curr){
            stack.push(curr);
            return;
        }
        
        int val = stack.pop();
        helper(stack , curr);
        stack.push(val);
        
    }
    
    public void sortStack(Stack<Integer> st) {
         if(st.isEmpty()){
             return;
         }
         int curr = st.pop();
         sortStack(st);
         helper(st,curr);
    }
}
