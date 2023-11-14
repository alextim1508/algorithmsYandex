import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Consumer;

public class TaskM {

    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        read();

        int[] colors = new int[adjList.size()];

        for (int i = 0; i < adjList.size(); i++) {
            if(colors[i] == 0){
                if(!isBipartition(adjList, i, colors, 1)) {
                    write(false);
                    return;
                }
            }
        }

        write(true);
    }

    public static boolean isBipartition(List<List<Integer>> adjList, int vertex, int[] colors, int color) {
        colors[vertex] = color;

        for (int i = 0; i < adjList.get(vertex).size(); i++) {
            if (colors[adjList.get(vertex).get(i)] == color)
                return false;
        }

        final int invertColor;
        if (color == 1) {
            invertColor = 2;
        } else {
            invertColor = 1;
        }

        for (int i = 0; i < adjList.get(vertex).size(); i++) {
            if (colors[adjList.get(vertex).get(i)] == 0) {
                if (!isBipartition(adjList, adjList.get(vertex).get(i), colors, invertColor))
                    return false;
            }
        }
        return true;
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
            adjList.get(vertex2).add(vertex1);
        }
    }

    private static void write(boolean isBipartition) {
        if(isBipartition)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
