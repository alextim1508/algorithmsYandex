import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskG {
    private static int[] arr1;
    private static int[] arr2;

    public static void main(String[] args) throws IOException {
        read();

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < arr1.length - arr2.length + 1; i++) {
            int delta = arr1[i] - arr2[0];
            boolean isOk = true;

            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i + j] != arr2[j] + delta) {
                    isOk = false;
                    break;
                }
            }

            if (isOk)
                indexes.add(i + 1);
        }

        write(indexes);
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        arr1 = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr1.length; i++)
            arr1[i] = Integer.parseInt(tokenizer.nextToken());

        arr2 = new int[Integer.parseInt(reader.readLine())];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr2.length; i++)
            arr2[i] = Integer.parseInt(tokenizer.nextToken());
    }

    private static void write(List<Integer> indexes) {
        StringBuilder out = new StringBuilder();

        for (int s : indexes) {
            out.append(s).append(" ");
        }

        System.out.println(out);
    }
}
