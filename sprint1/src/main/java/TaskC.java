import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TaskC {

    private static int rows;
    private static int columns;
    private static int[][] matrix;

    private static int targetX;
    private static int targetY;

    public static void main(String[] args) throws IOException {
        read();

        List<Integer> neighbors = new ArrayList<>();

        if (targetY - 1 >= 0)
            neighbors.add(matrix[targetY - 1][targetX]);
        if (targetY + 1 <= rows - 1)
            neighbors.add(matrix[targetY + 1][targetX]);
        if (targetX - 1 >= 0)
            neighbors.add(matrix[targetY][targetX - 1]);
        if (targetX + 1 <= columns - 1)
            neighbors.add(matrix[targetY][targetX + 1]);

        Collections.sort(neighbors);

        write(neighbors);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        rows = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
        columns = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());

        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        targetY = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
        targetX = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
    }

    private static void write(List<Integer> neighbors) {
        StringBuilder builder = new StringBuilder();
        for (int i : neighbors) {
            builder.append(i).append(" ");
        }
        System.out.println(builder);
    }
}
