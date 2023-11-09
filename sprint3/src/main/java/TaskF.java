import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskF {

    private static int[] ranges;

    public static void main(String[] args) throws IOException {
        read();

        Arrays.sort(ranges);

        for (int i = ranges.length - 1; i >= 2; i--) {
            if (ranges[i] < ranges[i - 1] + ranges[i - 2]) {
                write(String.valueOf(ranges[i] + ranges[i - 1] + ranges[i - 2]));
                return;
            }
        }
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ranges = new int[Integer.parseInt(reader.readLine())];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(String res) {
        System.out.println(res);
    }
}
