import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FinalTaskB {

    public static class InputData {
        public int[] arr;

        public InputData(int[] arr) {
            this.arr = arr;
        }
    }


    public static void main(String[] args) throws IOException {
        int[] arr = read().arr;
        write(isSplitIntoTwoEqualSumArrays(arr));
    }


    public static boolean isSplitIntoTwoEqualSumArrays(int[] arr) {
        int sum = 0;

        for (int k : arr)
            sum += k;

        if (sum % 2 != 0)
            return false;

        int rows = arr.length + 1;
        int columns = sum / 2 + 1;

        boolean[][] dp = new boolean[rows][columns];

        for (int i = 0; i < rows; i++)
            dp[i][0] = true;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[rows - 1][columns - 1];
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(tokenizer.nextToken());

        return new InputData(arr);
    }

    private static void write(boolean res) {
        if(res)
            System.out.println("True");
        else
            System.out.println("False");
    }
}


