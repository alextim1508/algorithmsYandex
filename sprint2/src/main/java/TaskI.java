import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskI {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        int maxSize = Integer.parseInt(reader.readLine());

        SizedQueue queue = new SizedQueue(maxSize);

        while (count-- != 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            switch (command) {
                case "push":
                    if (queue.size() == maxSize)
                        System.out.println("error");
                    else
                        queue.push(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "pop":
                    if(queue.size() == 0)
                        System.out.println("None");
                    else
                        System.out.println(queue.pop());
                    break;
                case "peek":
                    if(queue.size() == 0)
                        System.out.println("None");
                    else
                        System.out.println(queue.peek());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
            }
        }
    }

    private static class SizedQueue {

        private static final int CAPACITY = 5_000;

        private final int[] data;

        private int head;
        private int tail;
        private final int maxSize;

        public SizedQueue(int maxSize) {
            this.maxSize = maxSize;
            data = new int[CAPACITY];
        }

        public void push(int value) {
            data[tail++] = value;
        }

        public int pop() {
            return data[head++];
        }

        public int peek() {
            return data[head];
        }

        public int size() {
            return tail - head;
        }
    }
}
