import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskE {

    private static int[] housePrice;
    private static int budget;

    public static void main(String[] args) throws IOException {
        read();

        Arrays.sort(housePrice);

        int number;
        int sum = 0;

        for (number = 0; number < housePrice.length; number++) {
            if(sum + housePrice[number] <= budget) {
                sum += housePrice[number];
            } else
                break;
        }

        write(String.valueOf(number));
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        housePrice = new int[Integer.parseInt(tokenizer.nextToken())];
        budget = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < housePrice.length; i++) {
            housePrice[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(String res) {
        System.out.println(res);
    }
}