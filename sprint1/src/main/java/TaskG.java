import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskG {

    private static int number;

    public static void main(String[] args) throws IOException {
        read();

        if(number == 0 ) {
            write("0");
            return;
        }

        StringBuilder binaryNumber = new StringBuilder();

        while (number > 0) {
            binaryNumber.insert(0, number % 2);
            number /= 2;
        }

        write(binaryNumber.toString());
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        number = Integer.parseInt(reader.readLine());
    }

    private static void write(String binaryNumber) {
        System.out.println(binaryNumber);
    }
}
