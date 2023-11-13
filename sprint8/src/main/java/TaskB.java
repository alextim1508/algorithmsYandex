import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskB {

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

        if(Math.abs(in.s1.length() - in.s2.length()) > 1) {
            write(false);
            return;
        }

        int errors = 0;

        if(in.s1.length() == in.s2.length()) {
            for (int i = 0; i < in.s1.length(); i++) {
                if(in.s1.charAt(i) != in.s2.charAt(i)) {
                    errors++;

                    if(errors > 1) {
                        write(false);
                        return;
                    }
                }
            }
        } else {
            if(in.s1.length() < in.s2.length()) {
                String temp = in.s1;
                in.s1 = in.s2;
                in.s2 = temp;
            }

            for (int i = 0, j=0; i < in.s2.length(); i++, j++) {
                if(in.s1.charAt(i) != in.s2.charAt(j)) {
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

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();

        return new InputData(s1, s2);
    }

    private static void write(boolean isOk) {
        if(isOk)
            System.out.println("OK");
        else
            System.out.println("FAIL");
    }
}
