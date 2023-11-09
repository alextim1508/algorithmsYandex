import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskL {

    public static class InputData {
        public List<Set<Integer>> adjList;

        public InputData(List<Set<Integer>> adjList) {
            this.adjList = adjList;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData in = read();

        for (int i = 0; i < in.adjList.size(); i++) {
            if (in.adjList.get(i).size() < in.adjList.size() - 1 + (in.adjList.get(i).contains(i) ? 1 : 0)) {
                write(false);
                return;
            }
        }

        write(true);
    }


    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int vertex = Integer.parseInt(tokenizer.nextToken());

        List<Set<Integer>> adjList = new ArrayList<>(vertex);
        for (int i = 0; i < vertex; i++) {
            adjList.add(new HashSet<>());
        }

        int edge = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < edge; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertex1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int vertex2 = Integer.parseInt(tokenizer.nextToken()) - 1;
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }

        return new InputData(adjList);
    }

    private static void write(boolean isFull) {
        if(isFull)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
