import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TaskE {

    private static char[] chars;

    public static void main(String[] args) throws IOException {
        read();

        int[] map = new int['z' - 'a' + 1];

        int max = -1, len = 0, startMap = 0;

        for (int i = 0; i < chars.length; i++) {
            len++;

            int index = chars[i] - 'a';

            if (map[index] != 0) {
                startMap = Math.max(startMap, map[index]);
            }
            max = Math.max(max, i + 1 - startMap);

            map[index] = i + 1;
        }

        if (startMap == 0)
            write(len);
        else
            write(max);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        chars = reader.readLine().toCharArray();
    }

    private static void write(int max) {
        System.out.println(max);
    }
}