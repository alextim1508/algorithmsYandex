import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskG {

    private static int[] colors;

    public static void main(String[] args) throws IOException {
        read();

        int zeros = 0, ones = 0, twos = 0;

        for (int color : colors) {
            if (color == 0)
                zeros += 1;
            else if (color == 1)
                ones += 1;
            else if (color == 2)
                twos += 1;
        }

        StringBuilder out = new StringBuilder();

        while (zeros-- >0)
            out.append("0").append(" ");
        while (ones-- >0)
            out.append("1").append(" ");
        while (twos-- >0)
            out.append("2").append(" ");

        write(out.toString());
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        colors =  new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Integer.parseInt(tokenizer.nextToken());
        }
  }

    private static void write(String res) {
        System.out.println(res);
    }
}
