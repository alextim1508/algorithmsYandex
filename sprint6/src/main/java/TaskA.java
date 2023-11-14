import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskA {

    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        read();

        write(adjList);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int vertices = Integer.parseInt(tokenizer.nextToken());

        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++)
            adjList.add(new ArrayList<>(vertices * (vertices - 1)));

        int edges = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < edges; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertex1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int vertex2 = Integer.parseInt(tokenizer.nextToken());

            adjList.get(vertex1).add(vertex2);
        }
    }

    private static void write(List<List<Integer>> adjList) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < adjList.size(); i++) {

            out.append(adjList.get(i).size()).append(" ");

            for (int j = 0; j < adjList.get(i).size(); j++)
                out.append(adjList.get(i).get(j)).append(" ");
            out.append("\n");
        }

        System.out.println(out);
    }
}
