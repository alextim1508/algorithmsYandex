import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskI {

    public static class InputData {
        int number;

        public InputData(int number) {
            this.number = number;
        }
    }

    public static void main(String args[]) throws IOException {
        InputData input = read();
        write(catalan(input.number));
    }

    public static long catalan(int n) {
        if (n <= 1)
            return 1;

        long res = 0;
        for (int i = 0; i < n; i++)
            res += catalan(i)  * catalan(n - i - 1);
        return res;
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        return new InputData(number);
    }

    public static void write(long catalan) {
        System.out.println(catalan);
    }
}