import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskC {

    private static String str;

    public static void main(String[] args) throws IOException {
        read();

        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        StringBuilder res = new StringBuilder();
        char mid = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                res.append(chars[i]);
                i++;
            } else if (mid == 0) {
                mid = chars[i];
            }
        }

        if (res.length() == 0) {
            write(mid);
            return;
        }

        write(res, mid);
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = reader.readLine();
    }

    private static void write(StringBuilder res, char mid) {
        StringBuilder mirror = new StringBuilder(res);
        mirror.reverse();

        if (mid != 0)
            res.append(mid);

        System.out.println(res.append(mirror));
    }

    private static void write(char mid) {
        System.out.println(mid);
    }
}
