import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TaskP {

    private static int[] array;

    public static void main(String[] args) throws IOException {
        read();

        int count = 0;
        Set<Integer> set1 = new HashSet<>(array.length);
        Set<Integer> set2 = new HashSet<>(array.length);

        for (int i = 0; i < array.length; i++) {
            set1.clear();
            for (int j = 0; j < i; j++)
                set1.add(array[j]);

            set2.clear();
            for (int j = 0; j < i; j++)
                set2.add(j);

            if (set1.equals(set2))
                count++;
        }

        write(count);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        array = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(tokenizer.nextToken());
    }

    private static void write(int count) {
        System.out.println(count);
    }
}
