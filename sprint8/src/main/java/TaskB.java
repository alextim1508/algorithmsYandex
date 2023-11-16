import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskB {

    private static String s1;
    private static String s2;

    public static void main(String[] args) throws IOException {
        read();

        if(Math.abs(s1.length() - s2.length()) > 1) {
            write(false);
            return;
        }

        int errors = 0;

        if(s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    errors++;

                    if(errors > 1) {
                        write(false);
                        return;
                    }
                }
            }
        } else {
            if(s1.length() < s2.length()) {
                String temp = s1;
                s1 = s2;
                s2 = temp;
            }

            for (int i = 0, j=0; i < s2.length(); i++, j++) {
                if(s1.charAt(i) != s2.charAt(j)) {
                    errors++;

                    if(errors > 1) {
                        write(false);
                        return;
                    }

                    j--;
                }
            }
        }
        write(true);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s1 = reader.readLine();
        s2 = reader.readLine();
    }

    private static void write(boolean isOk) {
        if(isOk)
            System.out.println("OK");
        else
            System.out.println("FAIL");
    }
}
