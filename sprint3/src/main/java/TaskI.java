import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskI {

    private final static int MAX = 10_000;

    private static int[] students;
    private static int k;

    public static void main(String[] args) throws IOException {
        read();

        int[] counts = new int[MAX];
        for (int student : students)
            counts[student]++;


        StringBuilder out = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int maxIndex = 0;
            for (int j = 0; j < counts.length; j++)
                if(counts[j] > counts[maxIndex])
                    maxIndex = j;
            counts[maxIndex] = 0;
            out.append(maxIndex).append(" ");
        }

        write(out.toString());
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        students = new int[Integer.parseInt(reader.readLine())];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < students.length; i++)
            students[i] = Integer.parseInt(tokenizer.nextToken());

        k = Integer.parseInt(reader.readLine());
    }

    private static void write(String res) {
        System.out.println(res);
    }
}