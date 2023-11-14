import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

public class TaskD {

    private static List<Set<Integer>> adjList;
    private static int startVertex;

    public static void main(String[] args) throws IOException {
        read();

        boolean[] isUsed = new boolean[adjList.size()];

        List<Integer> order = new ArrayList<>(adjList.size());

        breadthFirstSearch(adjList, isUsed, startVertex, order::add);

        write(order);
    }

    private static void breadthFirstSearch(List<Set<Integer>> adjList, boolean[] isUsed, int vertex, Consumer<Integer> consumer) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (!isUsed[v]) {
                isUsed[v] = true;
                consumer.accept(v);
                queue.addAll(adjList.get(v));
            }
        }
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int vertex = Integer.parseInt(tokenizer.nextToken());

        adjList = new ArrayList<>(vertex);
        for (int i = 0; i < vertex; i++) {
            adjList.add(new TreeSet<>(Integer::compare));
        }

        int edge = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < edge; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertex1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int vertex2 = Integer.parseInt(tokenizer.nextToken()) - 1;
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }

        startVertex = Integer.parseInt(reader.readLine()) - 1;
    }

    private static void write(List<Integer> order) {
        StringBuilder out = new StringBuilder();
        order.forEach(v -> out.append(v + 1).append(" "));
        System.out.println(out);
    }
}
