import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskB {

    private static List<Lesson> lessons;

    public static class Lesson {
        public double start;
        public double finish;

        public Lesson(double start, double finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    public static void main(String[] args) throws IOException {
        read();

        lessons.sort(Comparator.comparingDouble((Lesson o) -> o.finish).thenComparingDouble(o -> o.start));

        List<Lesson> schedule = new ArrayList<>();

        double time = 0.0;
        for (int i = 0; i < lessons.size(); i++) {
            if(lessons.get(i).start >= time) {
                schedule.add(lessons.get(i));
                time = lessons.get(i).finish;
            }
        }

        write(schedule);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lessonsCount = Integer.parseInt(reader.readLine());

        lessons = new ArrayList<>();

        for (int i = 0; i < lessonsCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            lessons.add(new Lesson(
                    Double.parseDouble(tokenizer.nextToken()),
                    Double.parseDouble(tokenizer.nextToken())));
        }
    }

    private static void write(List<Lesson> schedule) {
        StringBuilder out = new StringBuilder();
        out.append(schedule.size()).append("\n");

        for (int i = 0; i < schedule.size(); i++) {
            out
                    .append(schedule.get(i).start % 1 == 0 ?
                            Integer.toString((int) schedule.get(i).start) : schedule.get(i).start)
                    .append(" ")
                    .append(schedule.get(i).finish % 1 == 0 ?
                            Integer.toString((int) schedule.get(i).finish) : schedule.get(i).finish)
                    .append("\n");
        }
        System.out.println(out);
    }
}
