import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskN {

    private static Flowerbed[] flowerbeds;

    public static class Flowerbed implements Comparable<Flowerbed> {
        public int start;
        public int end;

        public Flowerbed(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flowerbed o) {
            int comparison = Integer.compare(this.start, o.start);
            if (comparison == 0) {
                return -1 * Integer.compare(this.end, o.end);
            } else {
                return comparison;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        read();

        Arrays.sort(flowerbeds);

        int count = 0;

        for (int i = 1; i < flowerbeds.length; i++) {

            if (flowerbeds[count].end < flowerbeds[i].start || flowerbeds[count].start > flowerbeds[i].end) {
                // отдельная клумба
                flowerbeds[++count] = flowerbeds[i];

            } else { // пересекающийся с клумбой участок
                if (flowerbeds[count].start <= flowerbeds[i].start && flowerbeds[count].end >= flowerbeds[i].end) {
                    // внутри клумбы
                } else if (flowerbeds[count].start >= flowerbeds[i].start && flowerbeds[count].end <= flowerbeds[i].end) {
                    //снаружи клумбы
                    flowerbeds[count].start = flowerbeds[i].start;
                    flowerbeds[count].end = flowerbeds[i].end;

                } else if (flowerbeds[count].start >= flowerbeds[i].start && flowerbeds[count].end >= flowerbeds[i].end) {
                    //слева клумбы
                    flowerbeds[count].start = flowerbeds[i].start;

                } else if (flowerbeds[count].start <= flowerbeds[i].start && flowerbeds[count].end <= flowerbeds[i].end) {
                    //справа клумбы
                    flowerbeds[count].end = flowerbeds[i].end;
                }
            }
        }

        write(count);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        flowerbeds = new Flowerbed[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < flowerbeds.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            flowerbeds[i] = new Flowerbed(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }
    }

    private static void write(int count) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i <= count; i++)
            out.append(flowerbeds[i].start).append(" ").append(flowerbeds[i].end).append("\n");
        System.out.println(out);
    }
}