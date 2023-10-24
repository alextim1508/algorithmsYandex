import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TaskH {

    private static String str;

    public static void main(String[] args) throws IOException {
        read();

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{')
                stack.push(str.charAt(i));
            else {
                try {
                    if(str.charAt(i) == ')') {
                        if(stack.pop() != '(') {
                            write(false);
                            return;
                        }
                    } else if(str.charAt(i) == ']') {
                        if(stack.pop() != '[') {
                            write(false);
                            return;
                        }
                    } else if(str.charAt(i) == '}') {
                        if (stack.pop() != '{') {
                            write(false);
                            return;
                        }
                    }
                } catch (NoSuchElementException e) {
                    write(false);
                    return;
                }
            }
        }

        write(stack.isEmpty());
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = reader.readLine();
    }

    private static void write(boolean isValidSequence) {
        if(isValidSequence)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
