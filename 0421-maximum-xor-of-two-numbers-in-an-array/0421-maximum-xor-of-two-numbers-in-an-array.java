class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    // Insert a number bit by bit
    private void insert(int num) {

        TrieNode node = root;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >>> i) & 1;

            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }

            node = node.child[bit];
        }
    }

    // Find maximum XOR possible with num
    private int getMaxXor(int num) {

        TrieNode node = root;
        int xor = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >>> i) & 1;

            // We want opposite bit
            int opposite = 1 - bit;

            if (node.child[opposite] != null) {

                // XOR bit becomes 1
                xor |= (1 << i);

                node = node.child[opposite];

            } else {

                // Opposite doesn't exist
                node = node.child[bit];
            }
        }

        return xor;
    }

    public int findMaximumXOR(int[] nums) {

        // Insert all numbers into Trie
        for (int num : nums) {
            insert(num);
        }

        int max = 0;

        // Find best XOR partner for every number
        for (int num : nums) {
            max = Math.max(max, getMaxXor(num));
        }

        return max;
    }
}