//APPROACH IS simple .

// just push operand to stack and 
//when we get operator .just pop 2 operand from stack and make add operator btw that and make String

class Solution {
    static String postToInfix(String s) {
        Stack<String> st = new Stack<>();
        
        for(int i =0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }else{
                String s1 = st.pop(); //right
                String s2 = st.pop();//left
                String newStr = "("+s2+s.charAt(i)+s1+")";
                st.push(newStr);
            }
        }
        return st.pop();
        
    }
}
