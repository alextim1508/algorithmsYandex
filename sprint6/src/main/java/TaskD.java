import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

public class TaskD {

    public static class InputData {
        public List<Set<Integer>> adjList;
        public int startVertex;

        public InputData(List<Set<Integer>> adjList, int startVertex) {
            this.adjList = adjList;
            this.startVertex = startVertex;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        boolean[] isUsed = new boolean[in.adjList.size()];

        List<Integer> order = new ArrayList<>(in.adjList.size());

        breadthFirstSearch(in.adjList, isUsed, in.startVertex, order::add);

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

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int vertex = Integer.parseInt(tokenizer.nextToken());

        List<Set<Integer>> adjList = new ArrayList<>(vertex);
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

        int startVertex = Integer.parseInt(reader.readLine()) - 1;

        return new InputData(adjList, startVertex);
    }

    private static void write(List<Integer> order) {
        StringBuilder out = new StringBuilder();
        order.forEach(v -> out.append(v + 1).append(" "));
        System.out.println(out);
    }
}
