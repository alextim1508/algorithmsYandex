import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static int n;

    public static void main(String[] args) throws IOException {
        read();

        List<String> result = new ArrayList<>();

        gen(n, 0, 0, "", result);

        write(result);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
    }

    private static void write(List<String> result) {
        StringBuilder out = new StringBuilder();
        result.forEach(s -> out.append(s).append(System.lineSeparator()));
        System.out.println(out);
    }

    private static void gen(int n, int counterOpen, int counterClose, String ans, List<String> result) {
        if (counterOpen + counterClose == 2 * n) {
            result.add(ans);
            return;
        }
        if (counterOpen < n)
            gen(n, counterOpen + 1, counterClose, ans + "(", result);
        if (counterOpen > counterClose)
            gen(n, counterOpen, counterClose + 1, ans + ")", result);
    }
}
