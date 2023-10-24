import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskJ {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        ListQueue queue = new ListQueue();

        while (count-- != 0) {

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            switch (command) {
                case "put":
                    queue.put(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "get":
                    if(queue.getSize() == 0)
                        System.out.println("error");
                    else
                        System.out.println(queue.pop());
                    break;
                case "size":
                    System.out.println(queue.getSize());
                    break;
            }
        }
    }

    public static class ListQueue {
        private Node head;
        private Node tail;
        private int size;

        public void put(int value) {
            if (size == 0) {
                tail = head = new Node(value, null, null);
            } else {
                Node node = new Node(value, tail, null);
                tail.prev = node;
                tail = node;
            }
            size++;
        }

        public int pop() {
            int value = head.value;

            head = head.prev;
            if (head != null)
                head.next = null;

            size--;
            return value;
        }

        public int getSize() {
            return size;
        }
    }

    public static class Node {

        public int value;
        public Node next;
        public Node prev;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
