import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskE {

    private static class InputData {
        public int target;
        public int[] coins;

        public InputData(int target, int[] coins) {
            this.target = target;
            this.coins = coins;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        int[] dp = new int[in.target + 1];

        int countOfCoins = getCountOfCoins(in.target, in.coins, dp);

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

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(reader.readLine());

        int[] coins = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < coins.length; i++)
            coins[i] = Integer.parseInt(tokenizer.nextToken());

        return new InputData(target, coins);
    }

    private static void write(int countOfCoins) {
        System.out.println(countOfCoins);
    }
}
