import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskF {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        Stack stack = new Stack();

        while (count-- != 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "pop":
                    if(stack.size() == 0)
                        System.out.println("error");
                    else
                        stack.pop();
                    break;
                case "get_max":
                    if(stack.size() == 0)
                        System.out.println("None");
                    else
                        System.out.println(stack.getMax());
                    break;
            }
        }
    }

    private static class Stack {

        private static final int CAPACITY = 1_000;

        private final int[] data;
        private int top = -1;

        public Stack() {
            data = new int[CAPACITY];
        }

        public Stack(int capacity) {
            data = new int[capacity];
        }

        public void push(int value) {
            data[++top] = value;
        }

        public int pop() {
            return data[top--];
        }

        public int peek() {
            return data[top];
        }

        public int size() {
            return top + 1;
        }

        public int getMax() {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= top; i++) {
                if(max < data[i])
                    max = data[i];
            }
            return max;
        }
    }
}

