import java.io.*;
import java.util.*;

public class FinalTaskB {

    private static final int CAPACITY = 1_000;

    private static final String COMMAND_PUT = "put";
    private static final String COMMAND_GET = "get";
    private static final String COMMAND_DELETE = "delete";
    private static final String ERROR = "None";

    private static class InputData {
        public String[] commands;

        public InputData(String[] commands) {
            this.commands = commands;
        }
    }

    public static void main(String[] args) throws IOException {

        String[] commands = read().commands;

        MyHashMap<Integer, Integer> map = new MyHashMap<>(CAPACITY);

        List<String> result = new ArrayList<>(commands.length);

        for(String command: commands) {
            String[] commandParts = command.split(" ");

            if(commandParts[0].equals(COMMAND_PUT)) {

                int key = Integer.parseInt(commandParts[1]);
                int value = Integer.parseInt(commandParts[2]);

                map.put(key, value);
            } else if(commandParts[0].equals(COMMAND_GET)) {

                int key = Integer.parseInt(commandParts[1]);

                Integer value = map.get(key);
                if(value == null)
                    result.add(ERROR);
                else
                    result.add(String.valueOf(value));

            } else if(commandParts[0].equals(COMMAND_DELETE)) {

                int key = Integer.parseInt(commandParts[1]);

                Integer value = map.remove(key);
                if(value == null)
                    result.add(ERROR);
                else
                    result.add(String.valueOf(value));
            } else
                throw new RuntimeException("Unknown command");
        }

        write(result);
    }

    public static class MyHashMap<K, V> {

        Node<K, V>[] table;

        @SuppressWarnings("unchecked")
        public MyHashMap(int capacity) {
            this.table = (Node<K,V>[])new Node[capacity];
        }

        private int indexFor(int hash, int length) {
            return  hash % length;
        }

        protected int getHash(K key) {
            return key.hashCode();
        }

        public V put(K key, V value) {
            int index = indexFor(getHash(key), table.length);
            Node<K, V> node = table[index];

            while (node != null) {
                if (key.equals(node.getKey())) {
                    return node.setValue(value);
                }
                node = node.next;
            }

            node = table[index];
            if (node == null) {
                table[index] = new Node<>(key, value, null);
            } else {
                table[index] = new Node<>(key, value, node);
            }

            return null;
        }

        public V get(K key) {
            int index = indexFor(getHash(key), table.length);
            Node<K, V> node = table[index];

            while (node != null) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
                node = node.next;
            }
            return null;
        }

        public V remove(K key) {
            int index = indexFor(getHash(key), table.length);
            Node<K, V> node = table[index];
            Node<K, V> previous = null;

            while (node != null) {
                if (key.equals(node.getKey())) {
                    if (previous == null)
                        table[index] = node.next;
                    else
                        previous.next = node.next;
                    return node.getValue();
                }
                previous = node;
                node = node.next;
            }
            return null;
        }

        public static class Node<K, V> {

            private final K key;
            private V value;
            private Node<K, V> next;
            public Node(K key, V value, Node<K, V> next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            public V setValue(V value) {
                V oldValue = this.value;
                this.value = value;
                return oldValue;
            }
        }
    }

    private static void write(List<String> result) {
        StringBuilder out = new StringBuilder();
        for (String res : result)
            out.append(res).append(System.lineSeparator());
        System.out.println(out);
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < commands.length; i++) {
            commands[i] = reader.readLine();
        }
        return new InputData(commands);
    }
}