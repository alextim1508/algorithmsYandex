import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class TaskG {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        read();

        int sum = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                sum++;
            else
                sum--;
            arr[i] = sum;

            if (map.containsKey(sum))
                map.get(sum).add(i);
            else
                map.put(sum, new ArrayList<>(Collections.singletonList(i)));
        }

        int res = 0;
        for (Map.Entry<Integer, List<Integer>> s : map.entrySet()) {
            List<Integer> list = s.getValue();
            if (s.getKey() == 0) {
                res = Math.max(res, list.get(list.size() - 1) + 1);
            } else {
                res = Math.max(res, list.get(list.size() - 1) - list.get(0));
            }
        }

        write(res);
    }

    private static void read() throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        arr = new int[(int) in.nval];

        for (int i = 0; i < arr.length; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
    }

    private static void write(int res) {
        System.out.println(res);
    }
}