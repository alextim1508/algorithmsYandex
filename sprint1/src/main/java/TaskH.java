import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskH {

    private static String number1;
    private static String number2;

    public static void main(String[] args) throws IOException {
        read();

        int i1 = number1.length() - 1;
        int i2 = number2.length() - 1;

        int prevDigit = 0;

        List<Integer> number = new ArrayList<>();

        while (i1 >= 0 && i2 >= 0) {
            int digit1 = Character.getNumericValue(number1.charAt(i1));
            int digit2 = Character.getNumericValue(number2.charAt(i2));

            int sum = digit1 + digit2 + prevDigit;

            prevDigit = sum / 2;
            number.add(sum % 2);

            i1--;
            i2--;
        }

        while (i1 >= 0) {
            int digit = Character.getNumericValue(number1.charAt(i1));
            int sum = digit + prevDigit;

            prevDigit = sum / 2;
            number.add(sum % 2);

            i1--;
        }

        while (i2 >= 0) {
            int digit = Character.getNumericValue(number2.charAt(i2));
            int sum = digit + prevDigit;

            prevDigit = sum / 2;
            number.add(sum % 2);

            i2--;
        }

        if (prevDigit != 0)
            number.add(prevDigit);

        Collections.reverse(number);

        write(number);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        number1 = reader.readLine();
        number2 = reader.readLine();
    }

    private static void write(List<Integer> number) {
        StringBuilder builder = new StringBuilder();
        for (int i : number) {
            builder.append(i);
        }
        System.out.println(builder);
    }
}
