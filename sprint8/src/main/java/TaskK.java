import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskK {
    private static String s1;
    private static String s2;


    public static void main(String[] args) throws IOException {
        read();

        List<Character> transform1 = transform(s1.toCharArray());
        List<Character> transform2 = transform(s2.toCharArray());

        int i = 0;
        for (; i < transform1.size() && i < transform2.size(); i++) {
            if(transform1.get(i) > transform2.get(i)) {
                write(1);
                return;
            } else if(transform1.get(i) < transform2.get(i)) {
                write(-1);
                return;
            }
        }

        if(i < transform1.size()) {
            write(1);
            return;
        }

        if(i < transform2.size()) {
            write(-1);
            return;
        }

        write(0);
    }

    private static List<Character> transform(char[] str) {
        List<Character> rs = new ArrayList<>(str.length);

        for (int i = 0; i < str.length; i++) {
            if(str[i] % 2 == 0)
                rs.add(str[i]);
        }

        return rs;
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        s1 = reader.readLine();
        s2 = reader.readLine();
    }

    private static void write(int i) {
        System.out.println(i);
    }
}
