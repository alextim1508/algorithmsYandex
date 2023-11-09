import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskD {

    private static int[] kids;
    private static int[] cookies;

    public static void main(String[] args) throws IOException {
        read();

        Arrays.sort(kids);
        Arrays.sort(cookies);

        int cookieIndex = cookies.length - 1;

        for (int i = kids.length - 1; i >= 0; i--) {

            if (kids[i] <= cookies[cookieIndex]) {
                cookieIndex--;
            }
            if (cookieIndex == -1) {
                System.out.println(cookies.length - cookieIndex - 1);
                return;
            }
        }

        write(cookies.length - cookieIndex - 1);
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        kids = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < kids.length; i++) {
            kids[i] = Integer.parseInt(tokenizer.nextToken());
        }

        cookies = new int[Integer.parseInt(reader.readLine())];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < cookies.length; i++) {
            cookies[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(int n) {
        System.out.println(n);
    }
}