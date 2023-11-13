import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class TaskJ {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int[] arr1 = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr1.length; i++)
            arr1[i] = Integer.parseInt(tokenizer.nextToken());

        int[] arr2 = new int[Integer.parseInt(reader.readLine())];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr2.length; i++)
            arr2[i] = Integer.parseInt(tokenizer.nextToken());


        int dp[][] = new int[arr1.length+1][arr2.length+1];

        for (int i=0; i<= arr1.length; i++)  {
            for (int j=0; j<= arr2.length; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (arr1[i-1] == arr2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int nopLen = dp[arr1.length][arr2.length];
        out.append(nopLen).append("\n");

        List<Integer> answer = new ArrayList<>(nopLen);
        List<Integer> answer2 = new ArrayList<>(nopLen);

        for (int i = arr1.length, j = arr2.length; dp[i][j] != 0; ) {
            if(arr1[i-1] == arr2[j-1]) {
                answer.add(i);
                answer2.add(j);
                i--;
                j--;
            } else {
                if(dp[i][j] == dp[i-1][j]) {
                    i--;
                } else if( dp[i][j] == dp[i][j-1] ) {
                    j--;
                }
            }
        }

        for (int i = answer.size()-1; i >= 0 ; i--) {
            out.append(answer.get(i)).append(" ");
        }
        out.append("\n");
        for (int i = answer2.size()-1; i >= 0 ; i--) {
            out.append(answer2.get(i)).append(" ");
        }

        System.out.println(out);
    }

}
