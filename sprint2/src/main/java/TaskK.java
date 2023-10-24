import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskK {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        System.out.println(fibonacciNumbers(n));
    }

    private static int fibonacciNumbers(int n) {
        if(n <= 1)
            return 1;
        return fibonacciNumbers(n-1) + fibonacciNumbers(n-2);
    }
}
