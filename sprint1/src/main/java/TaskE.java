import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskE {

    private static String str;

    public static void main(String[] args) throws IOException {
        read();

        int start = 0;
        int count = 0;
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == ' ') {

                if(count > maxLength) {
                    start = i - count;
                    maxLength = count;
                }
                count = 0;
            } else {
                count++;
            }
        }


        if(count > maxLength) {
            start = str.length() - count;
            maxLength = count;
        }

        write(start, maxLength);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        reader.readLine();
        str = reader.readLine();
    }

    private static void write(int start, int len) {
        StringBuilder builder = new StringBuilder();
        builder.append(str, start, start + len).append(System.lineSeparator());
        builder.append(len);
        System.out.println(builder);
    }
}
