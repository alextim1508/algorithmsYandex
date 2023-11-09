import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskH {

    private static String[] numbers;

    public static void main(String[] args) throws IOException {
        read();

        Arrays.sort(numbers, (number1, number2) -> {
            String ab = number1 + number2;
            String ba = number2 + number1;
            return Integer.compare(Integer.parseInt(ba), Integer.parseInt(ab));
        });

        write();
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = new String[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = tokenizer.nextToken();
        }
    }

    private static void write() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            out.append(numbers[i]);
        }
        System.out.println(out);
    }

}

