import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskD {

    private static class InputData {
        public String[] words;

        public InputData(String[] words) {
            this.words = words;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] words = read().words;

        int size = Integer.MAX_VALUE;
        for (String word : words) {
            if (size > word.length())
                size = word.length();
        }

        int i = 0;
        for (; i < size; i++) {
            for (int j = 0; j < words.length-1; j++) {
                if(words[j].charAt(i) != words[j+1].charAt(i)) {
                    write(i);
                    return;
                }
            }
        }

        write(i);

    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < words.length; i++) {
            words[i] = reader.readLine();
        }

        return new InputData(words);
    }

    private static void write(int maxPrefixLen) {
        System.out.println(maxPrefixLen);
    }
}
