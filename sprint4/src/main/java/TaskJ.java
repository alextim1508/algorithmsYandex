import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskJ {

    private static long[] arr;
    private static int target;

    private static class Pair<K, V> {
        public K key;
        public V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        read();

        if (arr.length < 4) {
            write("0");
            return;
        }

        Arrays.sort(arr);

        Set<List<Long>> results = new TreeSet<>((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                int compare = Long.compare(o1.get(i), o2.get(i));
                if (compare != 0)
                    return compare;
            }
            return 0;
        });

        Map<Long, Pair<Long, Long>> pairs = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                long remainder = target - arr[i] - arr[j];
                if (pairs.containsKey(remainder)) {
                    Pair<Long, Long> pair = pairs.get(remainder);
                    try {
                        Math.multiplyExact(pair.key + pair.value, arr[i] + arr[j]);
                        results.add(Arrays.asList(pair.key, pair.value, arr[i], arr[j]));
                    } catch (ArithmeticException e) {
                    }
                }
            }

            for (int j = 0; j < i; j++) {
                long sum = arr[i] + arr[j];
                pairs.put(sum, new Pair<>(arr[j], arr[i]));
            }
        }

        write(results);
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        arr = new long[Integer.parseInt(reader.readLine())];
        target = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(Set<List<Long>> results) {
        StringBuilder out = new StringBuilder();
        out.append(results.size()).append(System.lineSeparator());
        results.forEach(result -> {
            result.forEach(i -> {
                out.append(i).append(" ");
            });
            out.append(System.lineSeparator());
        });

        System.out.println(out);
    }

    private static void write(String s) {
        System.out.println(s);
    }
}
