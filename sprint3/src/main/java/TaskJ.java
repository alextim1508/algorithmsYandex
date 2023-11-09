import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskJ {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        read();

        StringBuilder logger = new StringBuilder();
        if (isSorted(logger)) {
            write(List.of(logger.toString()));
            return;
        }

        List<String> loggerForEachIter = new ArrayList<>();
        bubbleSort(loggerForEachIter);
        write(loggerForEachIter);
    }

    private static boolean isSorted(StringBuilder logger) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
            }
            logger.append(arr[i]).append(" ");
        }
        logger.append(arr[arr.length - 1]);

        return isSorted;
    }

    private static void bubbleSort(List<String> loggerIter) {
        boolean isSorted;
        for (int i = 0; i < arr.length - 1; i++) {
            StringBuilder builder = new StringBuilder();
            isSorted = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isSorted = false;
                }
                builder.append(arr[j]).append(" ");
            }
            builder.append(arr[arr.length - 1]).append(System.lineSeparator());

            if (isSorted)
                break;

            loggerIter.add(builder.toString());
        }
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(List<String> res) {
        StringBuilder out = new StringBuilder();
        for (String s: res) {
            out.append(s);
        }

        System.out.println(out);
    }

}
