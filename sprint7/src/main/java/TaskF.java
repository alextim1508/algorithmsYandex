import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskF {
    private static int target;
    private static int k;

    public static void main(String[] args) throws IOException {
        read();

        int[] dp = new int[target];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int sum = 0;
            for (int j = 0; j < k ; j++) {
                if(i - 1 - j < 0)
                    break;

                sum += dp[i - j - 1];
                sum %= 1_000_000_007;
            }
            dp[i] = sum;
        }

        write(dp[dp.length - 1]);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] s = str.split(" ");
        target = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
    }

    private static void write(int numberOfWays) {
        System.out.println(numberOfWays);
    }
}
