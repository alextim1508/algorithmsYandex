import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskA {

    private static int a;
    private static int mod;
    private static String str;

    public static void main(String[] args) throws IOException {
        read();

        write(hash(str, a, mod));
    }

    private static long hash(String str, int a, int mod) {
        long res = 0;

        for (int i = 0; i < str.length(); i++)
            res = res * a % mod + str.charAt(i);
        return res;
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(reader.readLine());
        mod = Integer.parseInt(reader.readLine());
        str = reader.readLine();
    }

    private static void write(long hash) {
        System.out.println(hash);
    }
}