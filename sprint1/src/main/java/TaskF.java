import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskF {

    private static String str;

    public static void main(String[] args) throws IOException {
        read();

        str = format(str);

        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                write(false);
                return;
            }
        }

        write(true);
    }

    private static String format(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
                builder.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        return builder.toString();
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = reader.readLine();
    }

    private static void write(boolean isPalindrome) {
        if (isPalindrome)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
