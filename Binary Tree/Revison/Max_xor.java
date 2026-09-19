//understand problem problem then code as asked 

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private TrieNode root;
    private static final int BITS = 31; 

    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        int max = 0;

        for (int num : nums) {
            insert(num);
            max = Math.max(max, findMaxXorWith(num));
        }

        return max;
    }

    private void insert(int num) {
        TrieNode node = root;
        for (int i = BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    private int findMaxXorWith(int num) {
        TrieNode node = root;
        int result = 0;

        for (int i = BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int wantedBit = 1 - bit; 
            if (node.children[wantedBit] != null) {
                result |= (1 << i);
                node = node.children[wantedBit];
            } else {
                node = node.children[bit];
            }
        }

        return result;
    }
}
