import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskL {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        System.out.println(fibonacciNumbers(n, k));
    }

    private static int fibonacciNumbers(int n, int k) {
        int number1 = 1;
        int number2 = 1;

        for (int i = 0; i < n; i++) {
            int temp = number2;

            if(number1 + number2 > Math.pow(10, k))
                number2 = (number1 + number2) % (int) Math.pow(10, k);
            else
                number2 = (number1 + number2);

            number1 = temp;
        }

        return number1 % (int)Math.pow(10, k);
    }
}
