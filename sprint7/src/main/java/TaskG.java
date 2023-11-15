import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskG {

    private static int sum;
    private static int[] coins;


    public static void main(String[] args) throws IOException {
        read();

        Arrays.sort(coins);

        List<String> success = new ArrayList<>();
        search(sum, 0, coins, "", success);

        write(success.size());
    }

    private static void search(int remain, int i, int[] coins, String combinations, List<String> success) {
        if (remain == 0) {
            success.add(combinations);
            return;
        }

        if (coins[i] > remain)
            return;

        for (int j = i; j < coins.length; j++)
            search(remain - coins[j], j, coins, combinations + coins[j] + " ", success);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sum = Integer.parseInt(reader.readLine());
        coins = new int[Integer.parseInt(reader.readLine())];

        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(str[i]);
        }
    }

    private static void write(int size) {
        System.out.println(size);
    }
}
