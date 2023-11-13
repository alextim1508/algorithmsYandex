import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class TaskJ {

    private static class InputData {
        public String[] words;
        public String[] patterns;

        public InputData(String[] words, String[] patterns) {
            this.words = words;
            this.patterns = patterns;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        Trie trie = new Trie();

        for (int i = 0; i < in.words.length; i++) {
            trie.insert(in.words[i].replaceAll("[^A-Z]", ""), i);
        }

        TreeSet<String> set = new TreeSet<>();

        StringBuilder out = new StringBuilder();

        for(String pattern: in.patterns) {
            set.clear();


            if(pattern.isEmpty()) {
                set.addAll(Arrays.asList(in.words));
                set.forEach(s-> out.append(s).append(System.lineSeparator()));

            } else {
                TrieNode node = trie.find(pattern);
                if(node != null) {
                    for (int i = 0; i < node.content.size(); i++) {
                        set.add(in.words[node.content.get(i)]);
                    }
                    set.forEach(s-> out.append(s).append(System.lineSeparator()));
                } else {
                    out.append(System.lineSeparator());
                }
            }
        }


        write(out.toString());
    }

    public static class TrieNode {
        static int size = ('z' - 'a' + 1) + ('Z' - 'A' + 1);

        TrieNode[] children = new TrieNode[size];
        List<Integer> content = new ArrayList<>();
        boolean endOfWord;

        static int toChildIndex(char c) {
            if(c >= 'A' && c<= 'Z') {
                return c - 'A';
            } else if(c>= 'a' && c <= 'z') {
                return c - 'a' + 26;
            }
            throw new RuntimeException();
        }
    }

    public static class Trie {

        public TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        TrieNode insert(String word, int number) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                TrieNode children = node.children[TrieNode.toChildIndex(c)];

                if(children == null) {
                    TrieNode newNode = new TrieNode();
                    node.children[TrieNode.toChildIndex(c)] = newNode;
                    node = newNode;
                } else {
                    node = children;
                }

                node.content.add(number);
            }

            node.endOfWord = true;
            return node;
        }

        TrieNode find(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                TrieNode children = node.children[TrieNode.toChildIndex(c)];
                if(children == null) {
                    return null;
                } else {
                    node = children;
                }
            }

            return node;
        }
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < words.length; i++) {
            words[i] = reader.readLine();
        }

        String[] patterns = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < patterns.length; i++) {
            patterns[i] = reader.readLine();
        }
        return new InputData(words, patterns);
    }

    private static void write(String res) {
        System.out.println(res);
    }

}