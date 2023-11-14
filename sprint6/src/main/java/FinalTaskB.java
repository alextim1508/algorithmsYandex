import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalTaskB {

    private static char RAILROAD_TYPE = 'R';

    private static String[] roadsTypes;

    public static void main(String[] args) throws IOException {
        read();

        List<List<Integer>> adjList = createAdjList(roadsTypes);

        Graph graph = new Graph(adjList);

        Graph.Colors[] colors = new Graph.Colors[graph.getVertexCount()];
        Arrays.fill(colors, Graph.Colors.WHITE);

        for (int i = 0; i < graph.getVertexCount(); i++) {

            if (colors[i] == Graph.Colors.WHITE && graph.isCycle(i, colors)) {
                write(false);
                return;
            }
        }
        write(true);
    }



    public static class Graph {

        public enum Colors {
            WHITE, GREY, BLACK;
        }

        private final List<List<Integer>> adjList;
        private final int vertexCount;

        public Graph(List<List<Integer>> adjList) {
            this.adjList = adjList;
            vertexCount = adjList.size();
        }

        public boolean isCycle(int vertex, Colors[] colors) {
            colors[vertex] = Colors.GREY;

            for (int v : adjList.get(vertex)) {
                if(colors[v] == Colors.WHITE) {
                    if(isCycle(v, colors))
                        return true;
                } else if(colors[v] == Colors.GREY)
                    return true;
            }

            colors[vertex] = Colors.BLACK;
            return false;
        }

        public int getVertexCount() {
            return vertexCount;
        }
    }


    public static List<List<Integer>> createAdjList(String[] roadsTypes) {
        List<List<Integer>> adjList = new ArrayList<>(roadsTypes.length + 1);
        for (int i = 0; i < roadsTypes.length + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < roadsTypes.length; i++) {
            for (int j = 0; j < roadsTypes[i].length(); j++) {

                if(roadsTypes[i].charAt(j) == RAILROAD_TYPE)
                    adjList.get(i).add(i + j + 1);
                else
                    adjList.get(i + j + 1).add(i);
            }
        }
        return adjList;
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        roadsTypes = new String[count-1];

        for (int i = 0; i < roadsTypes.length; i++) {
            roadsTypes[i] = reader.readLine();
        }
    }

    private static void write(boolean isOptimal) {
        if(isOptimal)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
 