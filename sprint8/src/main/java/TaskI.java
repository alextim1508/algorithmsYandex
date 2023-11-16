import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskI {
    private static String str;


    public static void main(String[] args) throws IOException {
        read();

        int[] pi = kmp(str);
        int repeat = str.length()/(str.length() - pi[pi.length-1]);
        write(repeat);
    }

    public static int[] kmp(String str) {
        int[] pi = new int[str.length()];
        for (int i = 1; i < pi.length; i++) {
            int j = pi[i-1];
            while (j>0 && str.charAt(i) != str.charAt(j))
                j = pi[j-1];
            if(str.charAt(i) == str.charAt(j))
                j++;
            pi[i] = j;
        }
        return pi;
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = reader.readLine();
    }

    private static void write(int i) {
        System.out.println(i);
    }
}
