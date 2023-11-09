import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskB {

    public static class InputData {
        public int[][] adjMatrix;

        public InputData(int[][] adjMatrix) {
            this.adjMatrix = adjMatrix;
        }
    }

    public static void main(String[] args) throws IOException {
        write(read().adjMatrix);
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int vertex = Integer.parseInt(tokenizer.nextToken());
        int[][] adjMatrix = new int[vertex][vertex];

        int edges = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < edges; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertex1 = Integer.parseInt(tokenizer.nextToken())-1;
            int vertex2 = Integer.parseInt(tokenizer.nextToken())-1;
            adjMatrix[vertex1][vertex2] = 1;
        }

        return new InputData(adjMatrix);
    }

    private static void write(int[][] adjMatrix) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[0].length; j++)
                out.append(adjMatrix[i][j]).append(" ");
            out.append("\n");
        }

        System.out.println(out);
    }
}
