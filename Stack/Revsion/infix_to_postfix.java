class Solution {

  public static int priority(char ch) {
    if (ch == '^') return 3;
    if (ch == '/' || ch == '*')return 2;
    if (ch == '-' || ch == '+')return 1;
    return -1;
  }

  public static String infixToPostfix(String s) {
    Stack<Character> st = new Stack<>();

    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) { // or  Character.isLetterOrDigit(ch)
         
        ans.append(ch);
      } else if (ch == '(') {
        st.push(ch);
      } else if (ch == ')') {
        while (!st.isEmpty() && st.peek() != '(') {
          ans.append(st.pop());
        }
        if (!st.isEmpty())
          st.pop(); // remove '('
      } else {      // operator
        while (!st.isEmpty() && st.peek() != '(' &&
               (priority(st.peek()) > priority(ch) ||
                (priority(st.peek()) == priority(ch) && ch != '^'))) {
          ans.append(st.pop());
        }
        st.push(ch);
        
      }
    }

    while (!st.isEmpty()) {
      ans.append(st.pop());
    }
    return ans.toString();
  }
}
