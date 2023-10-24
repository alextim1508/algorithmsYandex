import java.util.Scanner;


public class FinalTaskB {

    public static final String ADD          = "+";
    public static final String SUB          = "-";
    public static final String MULTIPLY     = "*";
    public static final String DIVIDE       = "/";
    public static final String SPLITTER    = " ";

    public static void main(String[] args) {

        Stack stack = new Stack();

        for (String command : new Scanner(System.in).nextLine().split(SPLITTER)) {

            switch (command) {
                case ADD:
                    stack.push(stack.pop() + stack.pop());
                    break;
                case SUB: {
                    int secondOperand = stack.pop();
                    int firstOperand = stack.pop();
                    stack.push(firstOperand - secondOperand);
                    break;
                }
                case MULTIPLY:
                    stack.push(stack.pop() * stack.pop());
                    break;
                case DIVIDE: {
                    int secondOperand = stack.pop();
                    int firstOperand = stack.pop();

                    if(secondOperand == 0)
                        throw new RuntimeException("The sequence is not correct: division by zero");

                    stack.push(Math.floorDiv(firstOperand, secondOperand));
                    break;
                }
                default:
                    stack.push(Integer.parseInt(command));
                    break;
            }
        }
        System.out.println(stack.pop());
    }

    private static class Stack {

        private final int CAPACITY = 10_000;
        private final int[] data;

        private int top = -1;

        public Stack() {
            data = new int[CAPACITY];
        }

        public Stack(int capacity) {
            data = new int[capacity];
        }

        public int pop() {
            if(top < 0)
                throw new RuntimeException("The sequence is not correct: " +
                        "operands are missing to perform an arithmetic operation");
            return data[top--];
        }

        public void push(int value) {
            if(top >= CAPACITY-1)
                throw new RuntimeException("The sequence is not correct: " +
                        "the stack for storing operands is full");
            data[++top] = value;
        }

        public int peek() {
            if(top >= CAPACITY)
                throw new RuntimeException("The sequence is not correct: " +
                        "the stack for storing operands is full");
            return data[top];
        }

        public int size() {
            return top + 1;
        }
    }
}
