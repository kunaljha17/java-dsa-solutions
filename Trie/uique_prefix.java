public class uique_prefix {
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
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static void findPrefix(Node root , String ans){

        if (root == null) {
            return;
        }

        if (root.freq ==1) {
            System.out.print(ans+" ");
            return;
        }

        for(int i = 0;i<root.children.length;i++){
            if (root.children[i] != null) {
                char currChar = (char)(i+'a');
                findPrefix(root.children[i], ans+currChar);
            }
        }

    }
    
    public static void main(String[] args) {
        String words[] = {"zebra" , "dog" , "duck" , "dove"};
        for(int i = 0;i<words.length;i++){
            insert(words[i]);
        }
        root.freq = -1;

        findPrefix(root,  "");
    }
}
