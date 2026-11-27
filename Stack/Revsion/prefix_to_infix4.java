//Approach , Simple as postfix to infix . just reverse String 
// and s1 + s2 

// and done 

class Solution {
    public String preToInfix(String s) {
        Stack<String> st = new Stack<>();
        
         
        
        String newS = new StringBuilder(s).reverse().toString();
        
        for(int i =0;i<s.length();i++){

            char ch = newS.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch)); // yaha dhiyan dena hai kaise char ko string me krke add kiye stack me
            }else{
                String s1 = st.pop(); //right
                String s2 = st.pop();//left
                String newStr = "("+s1+newS.charAt(i)+s2+")";
                st.push(newStr);
            }
        }
         
        return st.pop();
    }
}
