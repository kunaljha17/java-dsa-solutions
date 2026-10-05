// Input: s = "(()())(())"
// Output: "()()()"

// Input: s = "(()())(())(()(()))"
// Output: "()()()()(())"




class Solution {
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder str = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch =='('){
                if(depth > 0){
                    str.append(ch);
                }
                depth++;
            }else{
                depth--;
                if(depth>0){
                    str.append(ch);
                }
            }
        }
        return str.toString();
    }
}
