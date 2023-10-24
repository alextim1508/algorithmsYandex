import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class TaskJ {

    private static int number;

    public static void main(String[] args) throws IOException {
        read();

        StringJoiner res = new StringJoiner(" ");
        int i = 2;
        while (i * i <= number) {
            while (number % i == 0) {
                number = number / i;
                res.add(Integer.toString(i));
            }
            i++;
        }

        if (res.length() == 0 || number > 1)
            res.add(Integer.toString(number));


        write(res.toString());
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(reader.readLine());
    }

    private static void write(String res) {
        System.out.println(res);
    }
}
