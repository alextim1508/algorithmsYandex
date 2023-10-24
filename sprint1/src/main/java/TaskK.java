import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskK {

    private static List<String> strX;
    private static int k;

    public static void main(String[] args) throws IOException {
        read();

        List<String> strK = format(k);

        List<String> res = new ArrayList<>();

        int tenScore = 0;
        int i;
        for (i = 0; i < strK.size() && i < strX.size(); i++) {

            int curX = Integer.parseInt(strX.get(strX.size() - 1 - i) );

            int curK = Integer.parseInt(strK.get(i));

            int sum = curK + curX + tenScore;

            tenScore = sum/10;

            res.add(Integer.toString(sum % 10));
        }

        while (i < strX.size()) {
            if(tenScore != 0) {
                res.add(Integer.toString(tenScore + Integer.parseInt(strX.get(strX.size() - 1 - i))));
                tenScore = 0;
            } else {
                res.add(strX.get(strX.size() - 1 - i));
            }
            i++;
        }

        while (i < strK.size()) {
            if(tenScore != 0) {
                res.add(Integer.toString(tenScore + Integer.parseInt(strK.get(i))));
                tenScore = 0;
            } else {
                res.add(strK.get(i));
            }
            i++;
        }

        if(tenScore != 0)
            res.add(Integer.toString(tenScore));

        write(res);
    }

    private static List<String> format(int number) {
        List<String> res  = new ArrayList<>();

        while (number > 0) {
            res.add(Long.toString(number % 10));
            number /= 10;
        }

        return res;
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lenX = Integer.parseInt(reader.readLine());
        strX = new ArrayList<>(lenX);

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < lenX; i++)
            strX.add(stringTokenizer.nextToken());

        k = Integer.parseInt(reader.readLine());
    }

    private static void write(List<String> sum) {
        StringBuilder builder = new StringBuilder();
        for (int i = sum.size()-1; i >= 0; i--) {
            builder.append(sum.get(i)).append(" ");
        }

        System.out.println(builder);
    }
}
