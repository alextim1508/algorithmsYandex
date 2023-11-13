import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskF {

    private static class InputData {
        public int target;
        public int k;

        public InputData(int target, int k) {
            this.target = target;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        int[] dp = new int[in.target];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int sum = 0;
            for (int j = 0; j < in.k ; j++) {
                if(i - 1 - j < 0)
                    break;

                sum += dp[i - j - 1];
                sum %= 1_000_000_007;
            }
            dp[i] = sum;
        }

        write(dp[dp.length - 1]);
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] s = str.split(" ");
        int k = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        return new InputData(k, n);
    }

    private static void write(int numberOfWays) {
        System.out.println(numberOfWays);
    }
}
