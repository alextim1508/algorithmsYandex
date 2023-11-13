import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskG {

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
        Arrays.sort(in.coins);

        List<String> success = new ArrayList<>();
        search(in.target, 0, in.coins, "", success);

        //System.out.println("success = " + success);
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

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(reader.readLine());
        int[] coins = new int[Integer.parseInt(reader.readLine())];

        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(str[i]);
        }
        return new InputData(sum, coins);
    }

    private static void write(int size) {
        System.out.println(size);
    }
}
