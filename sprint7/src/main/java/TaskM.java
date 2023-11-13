import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskM {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        int[] weights = new int[n];
        int[] cost = new int[n];

        int capacity = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < weights.length; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            weights[i] = Integer.parseInt(tokenizer.nextToken());
            cost[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= weights[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]] + cost[i-1]);
            }
        }

        int i = n;
        int j = capacity;

        int count = 0;
        while (dp[i][j] !=0) {
            if(dp[i][j] != dp[i-1][j]) {
                out.append(i).append(" ");
                count++;
                j -= weights[i-1];
            }
            i--;
        }

        out.insert(0, count + "\n");

        System.out.println(out);

    }
}
