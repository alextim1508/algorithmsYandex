import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FinalTaskA {

    public static final String PUSH_BACK    = "push_back";
    public static final String PUSH_FRONT   = "push_front";
    public static final String POP_FRONT    = "pop_front";
    public static final String POP_BACK     = "pop_back";
    public static final String ERROR        = "error";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int commandsCount = Integer.parseInt(reader.readLine());
        int maxSize = Integer.parseInt(reader.readLine());

        Deque deque = new Deque(maxSize);

        while (commandsCount-- != 0) {

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            switch (command) {

                case PUSH_BACK:
                    if (deque.isFull())
                        System.out.println(ERROR);
                    else
                        deque.pushBack(Integer.parseInt(tokenizer.nextToken()));
                    break;

                case PUSH_FRONT:
                    if (deque.isFull())
                        System.out.println(ERROR);
                    else
                        deque.pushFront(Integer.parseInt(tokenizer.nextToken()));
                    break;

                case POP_FRONT:
                    if (deque.isEmpty())
                        System.out.println(ERROR);
                    else
                        System.out.println(deque.popFront());
                    break;

                case POP_BACK:
                    if (deque.isEmpty())
                        System.out.println(ERROR);
                    else
                        System.out.println(deque.popBack());
                    break;
            }
        }
    }

    private static class Deque {

        private final int[] ring;
        private int size = 0;

        private int head;
        private int tail;

        public Deque(int capacity) {
            ring = new int[capacity];
            head = tail = 0;
        }

        public void pushBack(int value) {
            size++;

            ring[tail] = value;
            tail = (tail + 1) % ring.length;
        }

        public int popBack() {
            size--;

            tail = (tail - 1 + ring.length ) % ring.length;
            return ring[tail];
        }

        public void pushFront(int value) {
            size++;

            head = (head - 1 + ring.length ) % ring.length;
            ring[head] = value;
        }

        public int popFront() {
            size--;

            int value = ring[head];
            head = (head + 1) % ring.length;
            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == ring.length;
        }
    }
}