import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class FinalTaskA {

    private final static String ERROR_MSG = "Oops! I did it again";
    private static List<List<Edge>> adjList;

    public static void main(String[] args) throws IOException {
        read();

        Graph graph = new Graph(adjList);

        int sum = graph.getMstSum(0);

        write(sum);
    }

    public static class Graph {

        private final List<List<Edge>> edges;

        public Graph(List<List<Edge>> edges) {
            this.edges = edges;
        }

        public int getMstSum(int start) {
            int sum = 0;

            int[] maxWeights = new int[edges.size()];
            boolean[] mstVertices = new boolean[edges.size()];

            PriorityQueue<Edge> sortedEdges = new PriorityQueue<>((o1, o2) ->
                    Integer.compare(o2.weight, o1.weight));

            addVertexToMst(start, mstVertices, maxWeights, sortedEdges);

            int count = 1;

            while (!sortedEdges.isEmpty()) {

                Edge max = sortedEdges.poll();

                if(!mstVertices[max.end]) {
                    sum += max.weight;
                    addVertexToMst(max.end, mstVertices, maxWeights, sortedEdges);
                    count++;
                }
            }

            if(count == edges.size()) {
                return sum;
            }
            return -1;
        }

        private void addVertexToMst(int vertex,
                                    boolean[] mstVertices,
                                    int[] maxWeights,
                                    Queue<Edge> sortedEdges) {
            mstVertices[vertex] = true;
            List<Edge> edges = this.edges.get(vertex);

            if(edges != null) {
                for(Edge edge : edges) {
                    if(!mstVertices[edge.end] && maxWeights[edge.end] < edge.weight) {
                        maxWeights[edge.end] = edge.weight;
                        sortedEdges.add(edge);
                    }
                }
            }
        }
    }

    public static class Edge {
        public int weight;
        public int end;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int vertexesCount = Integer.parseInt(tokenizer.nextToken());
        int edgesCount = Integer.parseInt(tokenizer.nextToken());

        adjList = new ArrayList<>(vertexesCount);
        for (int i = 0; i < vertexesCount; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edgesCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertex1 = Integer.parseInt(tokenizer.nextToken())-1;
            int vertex2 = Integer.parseInt(tokenizer.nextToken())-1;
            int weight = Integer.parseInt(tokenizer.nextToken());

            if(vertex1 != vertex2) {
                adjList.get(vertex1).add(new Edge(vertex2, weight));
                adjList.get(vertex2).add(new Edge(vertex1, weight));
            }
        }
    }

    private static void write(int sum) {
        if(sum == -1) {
            System.out.println(ERROR_MSG);
        }
        System.out.println(sum);
    }

}