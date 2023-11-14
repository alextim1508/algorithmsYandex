import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskJ {

    private static List<List<Integer>> adjList;


    public static void main(String[] args) throws IOException {
        read();

        int[] colors = new int[adjList.size()];

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < adjList.size(); i++) {
            if(colors[i] == 0)
                depthFirstSearch(adjList, i, colors, stack);
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
            adjList.get(vertex1).add(vertex2);
        }
    }

    private static void write(LinkedList<Integer> stack) {
        StringBuilder out = new StringBuilder();

        while (!stack.isEmpty())
            out.append(stack.pop() + 1).append(" ");

        System.out.println(out);
    }


}
