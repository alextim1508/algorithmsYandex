import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FinalTaskB {



    public static void main(String[] args) throws IOException {

        Trie trie = new Trie();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String crib = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        while (n-- !=0) {
            trie.insert(reader.readLine());
        }

        System.out.println(canSplit(trie.root, crib, 0, new boolean[crib.length()]) ? "YES" : "NO");
    }

    private static class Trie {

        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char symbol = word.charAt(i);

                int index = TrieNode.getChildIndex(symbol);
                TrieNode child = node.children[index];

                if (child == null) {
                    TrieNode newNode = new TrieNode();
                    node.children[index] = newNode;
                    node = newNode;
                } else {
                    node = child;
                    node.content++;
                }
            }
            node.endOfWord = true;
        }
    }

    private static class TrieNode {
        private static final int size = ('z' - 'a' + 1) + ('Z' - 'A' + 1);

        public TrieNode[] children = new TrieNode[size];
        public int content;
        public boolean endOfWord;

        public static int getChildIndex(char c) {
            if (Character.isUpperCase(c)) {
                return c - 'A';
            } else if (Character.isLowerCase(c)) {
                return c - 'a' + size / 2;
            }
            throw new RuntimeException("Illegal symbol");
        }
    }

    private static boolean canSplit(TrieNode root, String word, int index, boolean[] memoization) {
        if (index < memoization.length && memoization[index])
            return false;

        TrieNode node = root;

        for (int i = index; i < word.length(); i++) {
            char symbol = word.charAt(i);

            node = node.children[TrieNode.getChildIndex(symbol)];

            if (node == null)
                return false;

            if (node.endOfWord) {
                if (canSplit(root, word, i + 1, memoization)) {
                    return true;
                } else {
                    memoization[i + 1] = true;
                }
            }
        }

        return (node == root);
    }
}
