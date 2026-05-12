public class Count_unique_substring {
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

    public static int countNode(Node root){
        if (root == null) {
            return 0;
        }
        int count =0;
        for(int i =0;i<26;i++){
            if (root.children[i] != null) {
                count += countNode(root.children[i]);
            }
        }
        return count+1;
    }




    public static void main(String[] args) {
        String str = "ababa";
        for(int i = 0;i<str.length();i++){
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNode(root));
    }
}
