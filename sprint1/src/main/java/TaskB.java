import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskB {

    private static int a;
    private static int b;
    private static int c;

    public static void main(String[] args) throws IOException {
        read();

        int res = Math.abs(a % 2) + Math.abs(b % 2) + Math.abs(c % 2);

        write(res == 0 || res == 3);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        a = Integer.parseInt(tokenizer.nextToken());
        b = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());
    }

    private static void write(boolean isWin) {
        if(isWin)
            System.out.println("WIN");
        else
            System.out.println("FAIL");
    }
}
