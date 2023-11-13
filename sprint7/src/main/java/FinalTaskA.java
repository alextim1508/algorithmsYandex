import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FinalTaskA {

    public static class InputData {
        public String str1;
        public String str2;

        public InputData(String str1, String str2) {
            this.str1 = str1;
            this.str2 = str2;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        write(levenshteinCalculation(in.str1, in.str2));
    }

    public static int levenshteinCalculation(String str1, String str2) {
        int[] prev = new int[ str2.length() + 1 ];

        for( int j = 0; j < str2.length() + 1; j++ ) {
            prev[j] = j;
        }

        for( int i = 1; i < str1.length() + 1; i++ ) {
            int[] curr = new int[ str2.length() + 1 ];
            curr[0] = i;

            for( int j = 1; j < str2.length() + 1; j++ ) {
                curr[ j ] = min(
                        prev[j] + 1,
                        curr[j - 1] + 1,
                        str1.charAt(i - 1) != str2.charAt(j - 1) ? prev[j - 1] +1 : prev[j - 1]);
            }

            prev = curr;
        }
        return prev[str2.length()];
    }

    public static int min(int... numbers) {
        int min = Integer.MAX_VALUE;
        for(int n : numbers) {
            if(min > n)
                min = n;
        }
        return min;
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();

        return new InputData(str1, str2);
    }

    private static void write(int distance) {
        System.out.println(distance);
    }
}