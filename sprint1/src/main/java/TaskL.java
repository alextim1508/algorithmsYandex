import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskL {

    private static char[] sequence1;
    private static char[] sequence2;

    public static void main(String[] args) throws IOException {
        read();

        Arrays.sort(sequence1);
        Arrays.sort(sequence2);

        for (int i = 0; i < sequence1.length && i < sequence2.length; i++) {
            if(sequence1[i] != sequence2[i]) {
                write(sequence2[i]);
                return;
            }
        }

        write(sequence2[sequence2.length-1]);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        sequence1 = tokenizer.nextToken().toCharArray();

        tokenizer = new StringTokenizer(reader.readLine());
        sequence2  = tokenizer.nextToken().toCharArray();
    }

    private static void write(char extraLetter) {
        System.out.println(extraLetter);
    }
}
