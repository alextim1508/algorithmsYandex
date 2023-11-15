import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskI {
    private static int[][] field;
    private static int rows;
    private static int columns;

    public static void main(String[] args) throws IOException {
        read();

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j <= columns - 1; j++) {
                if (i != rows - 1 && j != 0)
                    field[i][j] += Math.max(field[i + 1][j], field[i][j - 1]);
                else if (j != 0)
                    field[i][j] += field[i][j - 1];
                else if (i != rows - 1)
                    field[i][j] += field[i + 1][j];
            }
        }

        char[] path = new char[rows + columns - 2];
        int counter = 0, i = 0, j = columns-1;

        while (i != rows-1 || j != 0) {
            if (i == rows-1) {
                path[counter] = 'R';
                j--;
            } else if (j == 0){
                path[counter] = 'U';
                i++;
            } else {
                if (field[i + 1][j] > field[i][j - 1]) {
                    path[counter] = 'U';
                    i++;
                } else {
                    path[counter] = 'R';
                    j--;
                }
            }
            counter++;
        }

        write(field[0][columns-1], path);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        rows = Integer.parseInt(tokenizer.nextToken());
        columns = Integer.parseInt(tokenizer.nextToken());

        field = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String s = reader.readLine();
            for (int j = 0; j < columns; j++) {
                field[i][j] = s.charAt(j) == '1' ? 1 : 0;
            }
        }
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
