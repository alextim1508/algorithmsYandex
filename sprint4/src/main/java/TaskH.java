import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TaskH {

    private static String str1;
    private static String str2;

    public static void main(String[] args) throws IOException {
        read();

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        int length = Math.max(str1.length(), str2.length());

        boolean isEqual = true;

        for (int i = 0; i < length; i++) {
            char c1 = i < str1.length() ? str1.charAt(i) : ' ';
            char c2 = i < str2.length() ? str2.charAt(i) : ' ';

            if(map1.containsKey(c1)) {
                if(!map1.get(c1).equals(c2)) {
                    isEqual = false;
                    break;
                }
            } else {
                map1.put(c1, c2);
            }

            if(map2.containsKey(c2)) {
                if(!map2.get(c2).equals(c1)) {
                    isEqual = false;
                    break;
                }
            } else {
                map2.put(c2, c1);
            }
        }

        write(isEqual);
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str1 = reader.readLine();
        str2 = reader.readLine();
    }

    private static void write(boolean isEqual) {
        if(isEqual)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}