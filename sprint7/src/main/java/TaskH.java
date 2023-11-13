import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskH {

    private static class InputData {
        public int[][] field;
        public int rows;
        public int columns;

        public InputData(int[][] field, int rows, int columns) {
            this.field = field;
            this.rows = rows;
            this.columns = columns;
        }
    }

    public static void main(String[] args) throws IOException {

        InputData in = read();

        for (int i = in.rows - 1; i >= 0; i--) {
            for (int j = 0; j <= in.columns - 1; j++) {
                if (i != in.rows - 1 && j != 0)
                    in.field[i][j] += Math.max(in.field[i + 1][j], in.field[i][j - 1]);
                else if (j != 0)
                    in.field[i][j] += in.field[i][j - 1];
                else if (i != in.rows - 1)
                    in.field[i][j] += in.field[i + 1][j];
            }
        }
        write(in.field[0][in.columns-1]);
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int rows = Integer.parseInt(tokenizer.nextToken());
        int columns = Integer.parseInt(tokenizer.nextToken());

        int[][] field = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String s = reader.readLine();
            for (int j = 0; j < columns; j++) {
                field[i][j] = s.charAt(j) == '1' ? 1 : 0;
            }
        }

        return new InputData(field, rows, columns);
    }

    private static void write(int i) {
        System.out.println(i);
    }
}