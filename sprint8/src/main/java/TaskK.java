import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskK {

    private static class InputData {
        public String s1;
        public String s2;

        public InputData(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        List<Character> transform1 = transform(in.s1.toCharArray());
        List<Character> transform2 = transform(in.s2.toCharArray());

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


    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();

        return new InputData(s1, s2);
    }

    private static void write(int i) {
        System.out.println(i);
    }
}
