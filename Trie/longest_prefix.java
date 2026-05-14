public class longest_prefix {
      static class Node {
        Node children[];// size should be 26
        boolean endOfWord;
        int freq;

        Node() {
            children = new Node[26];
            freq = 1;
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String words) {
        Node curr = root;
        for (int i = 0; i < words.length(); i++) {
            int idx = words.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } 
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    static String ans = "";
    public static void longestPrefix(Node root , StringBuilder temp){
        if ( root == null) {
            return;
        }
        

        for(int i =0;i<26;i++){ //apple , apply
            if (root.children[i] !=null &&  root.children[i].endOfWord==true) {
                char ch = (char)(i+'a');

            // add character
            temp.append(ch);

            // update answer
            if (temp.length() > ans.length()) {
                ans = temp.toString();
            }

            // recursive call
            longestPrefix(root.children[i], temp);

            // backtracking
            temp.deleteCharAt(temp.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        String words [] = {"a","banana" , "app","appl", "ap" , "apply" , "apple"};
        for(int i = 0 ; i<words.length;i++){
            insert(words[i]);
        }
        longestPrefix(root,new StringBuilder(""));
         System.out.println(ans);
    }
}
