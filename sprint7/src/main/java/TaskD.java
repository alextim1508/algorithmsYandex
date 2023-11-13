import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskD {

    private static class InputData {
        public int n;

        public InputData(int n) {
            this.n = n;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = read().n;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_007;
        }

        write(dp[dp.length - 1]);
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        return new InputData(n);
    }

    private static void write(int n) {
        System.out.println(n);
    }
}
