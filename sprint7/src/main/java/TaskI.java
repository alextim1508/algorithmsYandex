import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskI {

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

        char[] path = new char[in.rows + in.columns - 2];
        int counter = 0, i = 0, j = in.columns-1;

        while (i != in.rows-1 || j != 0) {
            if (i == in.rows-1) {
                path[counter] = 'R';
                j--;
            } else if (j == 0){
                path[counter] = 'U';
                i++;
            } else {
                if (in.field[i + 1][j] > in.field[i][j - 1]) {
                    path[counter] = 'U';
                    i++;
                } else {
                    path[counter] = 'R';
                    j--;
                }
            }
            counter++;
        }

        write(in.field[0][in.columns-1], path);
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

    private static void write(int i, char[] path) {
        StringBuilder out = new StringBuilder();
        out.append(i).append("\n");
        for (int k = path.length-1; k >= 0; k--) {
            out.append(path[k]);
        }

        System.out.println(out);
    }
}
