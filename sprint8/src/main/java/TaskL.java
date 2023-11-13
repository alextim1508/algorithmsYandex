import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskL {

    private static class InputData {
        public String str;

        public InputData(String str) {
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        String str = read().str;

        int[] prefixFunction = prefixFunction(str.toCharArray());
        write(prefixFunction);
    }

    static int[] prefixFunction(char[] s) {
        int[] dp = new int[s.length ];
        for (int i = 1; i < s.length; i++) {
            int k = dp[i-1];
            while (k>0 && s[k] != s[i])
                k = dp[k-1];
            if(s[k] == s[i])
                k++;
            dp[i] = k;
        }
        return dp;
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        return new InputData(str);
    }

    private static void write(int[] prefixFunction) {
        StringBuilder out = new StringBuilder();

        for (int i : prefixFunction) {
            out.append(i).append(" ");
        }

        System.out.println(out);
    }
}