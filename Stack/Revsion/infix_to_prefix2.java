//Approach ,here we already done doing infix to postfix , So we use concept of there same here 

// Make String s reverse and store to new String , then . we simply do postfix conversion here .

//then we have ans String . Here i am doing reverse of ans String

// We have to mind this too..
//swap '(' with ')' and ')' with '('  . ( and ) swapped roles in the bracket handling
//change this equal-precedence condition changed from ch != '^' to ch == '^'

class Solution {

  public static int priority(char ch) {
    if (ch == '^')
      return 3;
    if (ch == '/' || ch == '*')
      return 2;
    if (ch == '-' || ch == '+')
      return 1;
    return -1;
  }

  static String infixToPrefix(String s) {

    Stack<Character> st = new Stack<>();

    StringBuilder ans = new StringBuilder();
    StringBuilder newS = new StringBuilder(s).reverse();

    for (int i = 0; i < newS.length(); i++) {
      char ch = newS.charAt(i);

      if (Character.isLetterOrDigit(ch)) { // operand

        ans.append(ch);
      } else if (ch == ')') {
        st.push(ch);
      } else if (ch == '(') {
        while (!st.isEmpty() && st.peek() != ')') {
          ans.append(st.pop());
        }
        if (!st.isEmpty())
          st.pop(); // remove ')'
      } else {      // operator
        while (!st.isEmpty() && st.peek() != ')' &&
               (priority(st.peek()) > priority(ch) ||
                (priority(st.peek()) == priority(ch) && ch == '^'))) {
          ans.append(st.pop());
        }
        st.push(ch);
      }
    }

    while (!st.isEmpty()) {
      ans.append(st.pop());
    }

    return ans.reverse().toString();
  }
}
