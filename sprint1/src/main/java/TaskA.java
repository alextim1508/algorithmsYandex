import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskA {

    private static int a;
    private static int b;
    private static int c;
    private static int x;

    public static void main(String[] args) throws IOException {

        read();

        int res = a * x * x + b * x + c;

        write(res);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        a = Integer.parseInt(tokenizer.nextToken());
        x = Integer.parseInt(tokenizer.nextToken());
        b = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());
    }

    private static void write(int res) {
        System.out.println(res);
    }
}

