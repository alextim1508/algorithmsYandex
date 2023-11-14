import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskF {

    private static List<List<Integer>> adjList;
    private static int start;
    private static int finish;


    public static void main(String[] args) throws IOException {
        read();

        boolean[] isUsed = new boolean[adjList.size()];
        int[] dist = new int[adjList.size()];
        Arrays.fill(dist, -1);

        if(start == finish) {
            write(0);
            return;
        }

        breadthFirstSearch(adjList, isUsed, start, finish, dist);

        write(dist[finish]);
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

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int vertex = Integer.parseInt(tokenizer.nextToken());

        adjList = new ArrayList<>(vertex);
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
        start = Integer.parseInt(tokenizer.nextToken()) - 1;
        finish = Integer.parseInt(tokenizer.nextToken()) - 1;
    }

    private static void write(int shortestDist) {
        System.out.println(shortestDist);
    }
}
