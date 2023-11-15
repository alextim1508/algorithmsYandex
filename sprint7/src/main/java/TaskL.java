import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskL {

    private static int[] weights;
    private static int capacity;

    public static void main(String[] args) throws IOException {
        read();

        boolean[][] dp = new boolean[weights.length + 1][capacity + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= weights[i-1] && dp[i-1][j - weights[i-1]])
                    dp[i][j] = true;
            }
        }

        int res = 0;
        for (int i = 0; i <= capacity ; i++) {
            if(dp[weights.length][i])
                res = i;
        }

        write(res);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        weights = new int[Integer.parseInt(tokenizer.nextToken())];
        capacity = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(int res) {
        System.out.println(res);
    }
}
