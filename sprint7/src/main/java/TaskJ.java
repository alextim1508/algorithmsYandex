import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TaskJ {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        read();

        int[] dp = new int[arr.length];

        ArrayList<Integer>[] sequences = new ArrayList[arr.length];
        for (int i = 0; i < sequences.length; i++) {
            sequences[i] = new ArrayList<>();
        }

        int globalMaxId = 0;

        for (int i = 0; i < arr.length; i++) {
            int maxId = findMaxId(arr, dp, i);
            dp[i] = dp[maxId] + 1;

            sequences[i].add(i);
            if (maxId != i)
                sequences[i].addAll(sequences[maxId]);

            if (dp[i] > dp[globalMaxId])
                globalMaxId = i;
        }

        write(dp, sequences, globalMaxId);
    }



    public static int findMaxId(int[] nums, int[] dp, int till){
        int max_id = till;

        for (int i = till-1; i >= 0; i--) {
            if (nums[i] < nums[till] && dp[i] > dp[max_id]) {
                max_id = i;
            }
        }

        return max_id;
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(tokenizer.nextToken());
    }

    private static void write(int[] dp, ArrayList<Integer>[] sequences, int globalMaxId) {
        StringBuilder out = new StringBuilder();
        out.append(dp[globalMaxId]).append("\n");

        ArrayList<Integer> result = sequences[globalMaxId];

        for (int i = result.size() - 1; i >= 0; i--) {
            out.append((result.get(i) + 1)).append(" ");
        }

        System.out.println(out);
    }
}
