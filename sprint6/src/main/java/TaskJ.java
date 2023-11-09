import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskJ {

    public static class InputData {
        public List<List<Integer>> adjList;

        public InputData(List<List<Integer>> adjList) {
            this.adjList = adjList;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        int[] colors = new int[in.adjList.size()];

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < in.adjList.size(); i++) {
            if(colors[i] == 0)
                depthFirstSearch(in.adjList, i, colors, stack);
        }

        write(stack);
    }

    private static void depthFirstSearch(List<List<Integer>> adjList, int vertex, int[] colors, LinkedList<Integer> stack) {
        colors[vertex] = 1;
        adjList.get(vertex).forEach(i -> {
            if(colors[i] == 0)
                depthFirstSearch(adjList, i, colors, stack);
        });
        stack.push(vertex);
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
        }

        return new InputData(adjList);
    }

    private static void write(LinkedList<Integer> stack) {
        StringBuilder out = new StringBuilder();

        while (!stack.isEmpty())
            out.append(stack.pop() + 1).append(" ");

        System.out.println(out);
    }


}
