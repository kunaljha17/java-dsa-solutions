public class startWith {
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

    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i =0;i<prefix.length();i++){
            int idx = (prefix.charAt(i)-'a');
            if (curr.children[idx]==null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {

         String words[] = {"zebra" , "dog" , "duck" , "dove"};
          for(int i = 0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println( startsWith("zeb"));
        System.out.print(startsWith("ele"));
        
    }
}
