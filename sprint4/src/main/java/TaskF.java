import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskF {

    private static String[] str;

    public static void main(String[] args) throws IOException {

        read();

        int[][] snapshots = convert();

        boolean[] anagrams = new boolean[snapshots.length];

        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < snapshots.length; i++) {
            List<Integer> result = new ArrayList<>();

            if(!anagrams[i]) {
                result.add(i);
                anagrams[i] = true;
            } else {
                continue;
            }

            for (int j = i+1; j < snapshots.length; j++) {
                if(areAnagram(snapshots[i], snapshots[j]) && !anagrams[j]) {
                    result.add(j);
                    anagrams[j] = true;
                }
            }
            results.add(result);
        }

        write(results);
    }

    private static int[][] convert() {
        int[][] arr = new int[str.length][];
        for (int i = 0; i < str.length; i++) {
            int[] res = new int['z' - 'a' +1];
            for (int j = 0; j < str[i].length(); j++) {
                res[str[i].charAt(j) - 'a']++;
            }
            arr[i] = res;
        }
        return arr;
    }

    private static boolean areAnagram(int[] number1, int[] number2) {
        for (int i = 0; i < number1.length; i++) {
            if(number1[i] != number2[i])
                return false;
        }
        return true;
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = new String[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < str.length; i++) {
            str[i] = tokenizer.nextToken();
        }
    }

    private static void write(List<List<Integer>> indexes) {
        StringBuilder out = new StringBuilder();
        for(List<Integer> anagramIndexes : indexes) {
            if(!anagramIndexes.isEmpty()) {
                for(int i: anagramIndexes)
                    out.append(i).append(" ");
                out.append(System.lineSeparator());
            }
        }
        System.out.println(out);
    }
}
