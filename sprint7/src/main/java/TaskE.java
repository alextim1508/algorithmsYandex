import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskE {

    private static int target;
    private static int[] coins;

    public static void main(String[] args) throws IOException {
        read();

        int[] dp = new int[target + 1];

        int countOfCoins = getCountOfCoins(target, coins, dp);

        if(countOfCoins != Integer.MAX_VALUE)
            write(countOfCoins);
        else
            write(-1);
    }

    public static int getCountOfCoins(int target, int[] coins, int[] dp) {
        if (target < 0)
            return Integer.MAX_VALUE - 1;

        if (target == 0)
            return 0;

        if (dp[target] != 0)
            return dp[target];

        int currentMin = Integer.MAX_VALUE - 1;
        for (int coin : coins) {
            currentMin = Math.min(getCountOfCoins(target - coin, coins, dp) + 1, currentMin);
        }

        dp[target] = currentMin;

        return currentMin;
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(reader.readLine());

        coins = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < coins.length; i++)
            coins[i] = Integer.parseInt(tokenizer.nextToken());

    }

    private static void write(int countOfCoins) {
        System.out.println(countOfCoins);
    }
}
