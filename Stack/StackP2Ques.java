import java.util.*;

public class StackP2Ques {

    public static boolean IsValidParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if (s.peek() == '(' && ch == ')' || s.peek() == '{' && ch == '}' || s.peek() == '[' && ch == ']') {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (!s.isEmpty()) {
            return false;
        }
        return true;

    }

    public static boolean DuplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            int size = 0;
            if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    size++;
                }
                if (size == 0) {
                    return true;
                }else{
                    s.pop(); // remove '('
                }
            } else {
                s.push(ch);
            }

        }
        return false;
    }

    public static int MaxAreaHistogram(int height[]){
        Stack<Integer> s = new Stack<>();
        int LeftSmaller[] = new int[height.length];
        int RightSmaller[] = new int[height.length];
        
        //leftSmaller height
        for(int i = 0;i<height.length;i++){
            //lefts
             while (!s.isEmpty()&&height[i]<height[s.peek()]) {
                s.pop();
             }
             if (s.isEmpty()) {
                LeftSmaller[i] = -1;
             }
             else  {
                LeftSmaller[i] = s.peek();
             }
             s.push(i);
        }
        //RightSmaller height

        s = new Stack<>();
        for(int i = height.length-1;i>=0;i--){
            //lefts
             while (!s.isEmpty()&&height[i]<height[s.peek()]) {
                s.pop();
             }
             if (s.isEmpty()) {
                RightSmaller[i] = height.length;
             }
             else  {
                RightSmaller[i] = s.peek();
             }
             s.push(i);
        }

        //Curr area :width = j-i-1
        int maxArea = 0;
        for(int i =0;i<height.length;i++){
            int width = RightSmaller[i] - LeftSmaller[i]-1;
             maxArea = Math.max(maxArea, width*height[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        String str = "))";
        System.out.println(DuplicateParentheses(str));
    }
}
