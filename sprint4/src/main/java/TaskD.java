import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


public class TaskD {

    private static String[] courses;

    public static void main(String[] args) throws IOException {

        read();

        LinkedHashSet<String> visitedCourses = new LinkedHashSet<>(Arrays.asList(courses));

        write(visitedCourses);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        courses = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = reader.readLine();
        }
    }

    private static void write(Set<String> visitedCourses) {
        StringBuilder out = new StringBuilder();
        for(String course: visitedCourses)
            out.append(course).append(System.lineSeparator());
        System.out.println(out);
    }
}