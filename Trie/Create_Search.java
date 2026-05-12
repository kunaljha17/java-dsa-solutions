public class Create_Search {
    static class Node {
        Node children[];// size should be 26
        boolean endOfWord;

        Node() {
            children = new Node[26];
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

    public static boolean Search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord == true;
    }

    public static boolean wordBreak(String key) {

        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <=key.length(); i++) {
            if (Search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        String words[] ={"i", "like" , "sam","samsung","mobile" ,"ice"};

        for(int i = 0;i<words.length;i++){
           insert(words[i]);
        }

        // System.out.print(Search("their"));

        String key = "ilikesamsung";

        System.out.println(wordBreak(key)); 
    }
}
