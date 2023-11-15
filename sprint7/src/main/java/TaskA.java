import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskA {

    private static int[] prices;

    public static void main(String[] args) throws IOException {
        read();

        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            int delta = prices[i] - prices[i - 1];
            if (delta > 0)
                sum += delta;
        }

        write(sum);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        prices = new int[Integer.parseInt(reader.readLine())];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(int sum) {
        System.out.println(sum);
    }
}
