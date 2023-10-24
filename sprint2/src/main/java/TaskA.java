import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskA {

    private static int rows;
    private static int columns;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        read();

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++)
                out.append(matrix[j][i]).append(" ");
            out.append(System.lineSeparator());
        }

        write(out.toString());
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        rows = Integer.parseInt(reader.readLine());
        columns = Integer.parseInt(reader.readLine());
        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }

    private static void write(String transposedMatrix ) {
        System.out.println(transposedMatrix);
    }
}
