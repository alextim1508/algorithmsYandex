import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskA {

    public static class InputData {
        public int[] prices;

        public InputData(int[] prices) {
            this.prices = prices;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] prices = read().prices;

        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            int delta = prices[i] - prices[i - 1];
            if (delta > 0)
                sum += delta;
        }

        write(sum);
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] prices = new int[Integer.parseInt(reader.readLine())];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(tokenizer.nextToken());
        }

        return new InputData(prices);
    }

    private static void write(int sum) {
        System.out.println(sum);
    }
}
