import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskG {

    public static class InputData {
        public List<List<Integer>> adjList;
        public int start;

        public InputData(List<List<Integer>> adjList, int start) {
            this.adjList = adjList;
            this.start = start;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        int[] colors = new int[in.adjList.size()];
        int[] distance = new int[in.adjList.size()];

        breadthFirstSearch(in.adjList, in.start, colors, distance);

        int max = getMax(distance);

        write(max);
    }

    private static void breadthFirstSearch(List<List<Integer>> adjList, int vertex, int[] color, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        color[vertex] = 1;
        distance[vertex] = 0;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            adjList.get(v).forEach(u -> {
                if(color[u] == 0) {
                    distance[u] = distance[v] + 1;
                    color[u] = 1;
                    queue.add(u);
                }
            });
            color[v] = 2;
        }
    }

    private static int getMax(int[] distance) {
        int max = -1;
        for (int i : distance) {
            if (i > max)
                max = i;
        }
        return max;
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
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }

        int start = Integer.parseInt(reader.readLine())-1;

        return new InputData(adjList, start);
    }

    private static void write(int maxDist) {
        System.out.println(maxDist);
    }
}
