//Approach is simple just .push operand to stack and when we get operator then . from stack pop() s1 and s2 then , make one string and again push it back to stack



class Solution {
    static String postToPre(String s) {
        Stack<String> st = new Stack<>();
        
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }else{
                String s1 = st.pop();
                String s2 = st.pop();
                st.push(ch+s2+s1);
            }
        }
        return st.pop();
        
    }
}
