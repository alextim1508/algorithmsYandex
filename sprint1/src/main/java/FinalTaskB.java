import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FinalTaskB {

    private static int limit;
    private static int[] counts;

    private static final int PLAYERS_AMOUNT = 2;
    private static final int FIELD_SIZE = 4;
    private static final int COUNT_SIZE = 9;

    public static void main(String[] args) throws IOException {
        read();

        int scores = 0;

        for(int i : counts) {
            if(i != 0 && limit >= i)
                scores++;
        }

        write(scores);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        limit = PLAYERS_AMOUNT * Integer.parseInt(tokenizer.nextToken());

        counts = new int[COUNT_SIZE];

        for (int i = 0; i < FIELD_SIZE; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            for(char c: tokenizer.nextToken().toCharArray()) {
                if(c != '.') {
                    counts[Character.getNumericValue(c)-1]++;
                }
            }
        }
    }

    private static void write(int scores) {
        System.out.println(scores);
    }
}
