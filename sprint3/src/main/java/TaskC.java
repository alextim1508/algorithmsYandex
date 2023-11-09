import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskC {

    private static String str1;
    private static String str2;

    public static void main(String[] args) throws IOException {
        read();

        if(str1.isEmpty()) {
            write("True");
            return;
        }

        if(str1.length() > str2.length()) {
            write("False");
            return;
        }

        for (int i=0, j=0; i < str2.length(); i++) {
            if(str1.charAt(j) == str2.charAt(i)) {
                if(++j == str1.length()) {
                    write("True");
                    return;
                }
            }
        }

        write("False");
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str1 = reader.readLine();
        str2 = reader.readLine();
    }

    private static void write(String res) {
        System.out.println(res);
    }

}

