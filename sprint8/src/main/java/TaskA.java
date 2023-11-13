import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskA {

    private static class InputData {
        public String[] words;

        public InputData(String[] words) {
            this.words = words;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] words = read().words;
        String[] reverseOrder = new String[words.length];

        for (int i = words.length - 1; i >= 0; i--) {
            reverseOrder[words.length -1 - i] = words[i];
        }

        write(reverseOrder);
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split(" ");

        return new InputData(words);
    }

    private static void write(String[] words) {
        StringBuilder out = new StringBuilder();

        for (String s : words) {
            out.append(s).append(" ");
        }

        System.out.println(out);
    }
}
