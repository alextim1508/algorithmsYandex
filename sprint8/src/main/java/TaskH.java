import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class TaskH {

    private static class InputData {
        public String text;
        public String pattern;
        public String word;

        public InputData(String text, String pattern, String word) {
            this.text = text;
            this.pattern = pattern;
            this.word = word;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        int i = in.text.indexOf(in.pattern);
        if(i != -1) {
            in.text = in.text.replace(in.pattern, in.word);
            i = in.text.indexOf(in.pattern, i + in.word.length());
        }

        write(in.text);
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String pattern = reader.readLine();
        String word = reader.readLine();

        return new InputData(text, pattern, word);
    }

    private static void write(String text) {
        System.out.println(text);
    }
}
