import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskF {

    public static class InputData {
        public List<List<Integer>> adjList;
        public int start;
        public int finish;

        public InputData(List<List<Integer>> adjList, int start, int finish) {
            this.adjList = adjList;
            this.start = start;
            this.finish = finish;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        boolean[] isUsed = new boolean[in.adjList.size()];
        int[] dist = new int[in.adjList.size()];
        Arrays.fill(dist, -1);

        if(in.start == in.finish) {
            write(0);
            return;
        }

        breadthFirstSearch(in.adjList, isUsed, in.start, in.finish, dist);

        write(dist[in.finish]);
    }

    private static void breadthFirstSearch(List<List<Integer>> graph, boolean[] isUsed, int start, int finish, int[] dist) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        isUsed[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Integer v : graph.get(u)) {
                if (!isUsed[v]) {
                    isUsed[v] = true;
                    dist[v] = dist[u] + 1;
                    if (v == finish)
                        return;
                    queue.add(v);
                }
            }

        }
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int vertex = Integer.parseInt(tokenizer.nextToken());

        List<List<Integer>> adjList = new ArrayList<>(vertex);
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        int edge = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < edge; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertex1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int vertex2 = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (vertex1 != vertex2) {
                adjList.get(vertex1).add(vertex2);
                adjList.get(vertex2).add(vertex1);
            }
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken()) - 1;
        int finish = Integer.parseInt(tokenizer.nextToken()) - 1;

        return new InputData(adjList, start, finish);
    }

    private static void write(int shortestDist) {
        System.out.println(shortestDist);
    }
}
