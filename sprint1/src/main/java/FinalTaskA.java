import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class FinalTaskA {

    private static int[] houses;

    public static void main(String[] args) throws IOException {
        read();

        int[] distances = new int[houses.length];
        initializeWithMaxDistance(distances);

        distancesCalcToRight(distances);
        distancesCalcToLeft(distances);

        write(distances);
    }

    private static void initializeWithMaxDistance(int[] distances) {
        Arrays.fill(distances, distances.length);
    }

    private static void distancesCalcToRight(int[] distances) {
        boolean countStarted = false;
        int count = 0;

        for (int i = 0; i < houses.length; i++) {

            if(houses[i] == 0 && !countStarted)
                countStarted = true;

            if(countStarted) {
                if(houses[i] == 0)
                    count = 0;
                else
                    count++;

                distances[i] = Math.min(distances[i], count);
            }
        }
    }

    private static void distancesCalcToLeft(int[] distances) {
        boolean countStarted = false;
        int count = 0;

        for (int i = houses.length - 1; i >= 0; i--) {

            if(houses[i] == 0 && !countStarted)
                countStarted = true;

            if(countStarted) {
                if(houses[i] == 0)
                    count = 0;
                else
                    count++;

                distances[i] = Math.min(distances[i], count);
            }
        }
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        houses = new int[Integer.parseInt(tokenizer.nextToken())];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < houses.length; i++) {
            houses[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(int[] distances) {
        StringBuilder builder = new StringBuilder();
        for(int i : distances) {
            builder.append(i).append(" ");
        }
        System.out.println(builder);
    }
}
