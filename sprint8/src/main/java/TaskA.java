import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskA {

    private static String[] words;

    public static void main(String[] args) throws IOException {
        read();

        String[] reverseOrder = new String[words.length];

        for (int i = words.length - 1; i >= 0; i--) {
            reverseOrder[words.length -1 - i] = words[i];
        }

        write(reverseOrder);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        words = reader.readLine().split(" ");
    }

    private static void write(String[] words) {
        StringBuilder out = new StringBuilder();

        for (String s : words) {
            out.append(s).append(" ");
        }

        System.out.println(out);
    }
}
