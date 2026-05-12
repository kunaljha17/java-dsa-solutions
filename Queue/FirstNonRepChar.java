import java.util.*;

public class FirstNonRepChar {

    public static void FirstNonRepeatingChar(String str) {
        Queue<Character> q = new LinkedList<>();//stores order of characters
        int freq[] = new int[26];//a to z

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;//inc frequency 

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {//remove characters from queue which are repeating (freq > 1)
                q.remove();//Remove all characters from front that are repeating
            }
            if (q.isEmpty()) {//if q is empty after removing 
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        FirstNonRepeatingChar(str);
    }
}