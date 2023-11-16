import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class TaskH {

    private static String text;
    private static String pattern;
    private static String word;


    public static void main(String[] args) throws IOException {
        read();

        int i = text.indexOf(pattern);
        if(i != -1) {
            text = text.replace(pattern, word);
            i = text.indexOf(pattern, i + word.length());
        }

        write(text);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        text = reader.readLine();
        pattern = reader.readLine();
        word = reader.readLine();
    }

    private static void write(String text) {
        System.out.println(text);
    }
}
