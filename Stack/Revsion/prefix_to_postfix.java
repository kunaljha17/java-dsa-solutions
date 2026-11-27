//approach , similar to postfix to prefix .
// 


class Solution {
    static String preToPost(String s) {
        Stack<String> st = new Stack<>();
        
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }else{
                String s1 =st.pop();
                String s2 = st.pop();
                st.push(s1+s2+ch); //only change this here  
            }
        }
        return st.pop();
    }
}
