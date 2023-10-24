import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskD {

    private static int[] days;

    public static void main(String[] args) throws IOException {
        read();

        if(days.length == 0) {
            write(0);
            return;
        }

        if(days.length == 1) {
            write(1);
            return;
        }

        int count = 0;

        if(days[0] > days[1])
            count++;

        if(days[days.length - 2] < days[days.length-1])
            count++;

        for (int i = 1; i < days.length-1; i++) {
            if(days[i - 1] < days[i] && days[i] > days[i + 1])
                count++;
        }

        write(count);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        days = new int[Integer.parseInt( new StringTokenizer(reader.readLine()).nextToken())];
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < days.length; i++) {
            days[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void write(int count) {
        System.out.println(count);
    }
}