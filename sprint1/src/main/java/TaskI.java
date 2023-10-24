import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskI {

    private static int MAX_N = 10_000;
    private static int number;

    public static void main(String[] args) throws IOException {
        read();

        int maxPower = (int)Math.floor(log(4, MAX_N));

        int _4OfPowerN = 1;
        for (int i = 0; i < maxPower; i++) {

            if(_4OfPowerN == number) {
                write(true);
                return;
            }

            _4OfPowerN *= 4;
        }

        write(false);
    }

    private static double log(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        number = Integer.parseInt(reader.readLine());
    }

    private static void write(boolean is4toPowerN) {
        if(is4toPowerN)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
