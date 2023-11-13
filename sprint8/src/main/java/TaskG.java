import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskG {

    private static class InputData {
        public int[] arr1;
        public int[] arr2;

        public InputData(int[] arr1, int[] arr2) {
            this.arr1 = arr1;
            this.arr2 = arr2;
        }
    }


    public static void main(String[] args) throws IOException {
        InputData in = read();

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < in.arr1.length - in.arr2.length + 1; i++) {
            int delta = in.arr1[i] - in.arr2[0];
            boolean isOk = true;

            for (int j = 1; j < in.arr2.length; j++) {
                if (in.arr1[i + j] != in.arr2[j] + delta) {
                    isOk = false;
                    break;
                }
            }

            if (isOk)
                indexes.add(i + 1);
        }

        write(indexes);
    }


    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr1 = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr1.length; i++)
            arr1[i] = Integer.parseInt(tokenizer.nextToken());

        int[] arr2 = new int[Integer.parseInt(reader.readLine())];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr2.length; i++)
            arr2[i] = Integer.parseInt(tokenizer.nextToken());

        return new InputData(arr1, arr2);
    }

    private static void write(List<Integer> indexes) {
        StringBuilder out = new StringBuilder();

        for (int s : indexes) {
            out.append(s).append(" ");
        }

        System.out.println(out);
    }
}
