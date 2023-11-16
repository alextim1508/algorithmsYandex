import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TaskF {

    private static String[] words;


    public static void main(String[] args) throws IOException {
        read();

        Map<String, Integer> map = new HashMap<>();
        String mostFrequentWord = "";
        int freq = 0;

        for (String word : words) {

            Integer count = map.get(word);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(word, count);

            if (freq == count) {
                if (mostFrequentWord.compareTo(word) > 0) {
                    mostFrequentWord = word;
                }
            }

            if (freq < count) {
                freq = count;
                mostFrequentWord = word;
            }
        }

        write(mostFrequentWord);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        words = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < words.length; i++) {
            words[i] = reader.readLine();
        }
    }

    private static void write(String word) {
        System.out.println(word);
    }
}

