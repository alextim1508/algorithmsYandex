import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TaskB {

    private static String digit;

    private static final HashMap<Character, String> keys = new HashMap<>();
    static {
        keys.put('2', "abc");
        keys.put('3', "def");
        keys.put('4', "ghi");
        keys.put('5', "jkl");
        keys.put('6', "mno");
        keys.put('7', "pqrs");
        keys.put('8', "tuv");
        keys.put('9', "wxyz");
    }

    public static void main(String[] args) throws IOException {
        read();

        StringBuilder out = new StringBuilder();
        createCombinations(digit, "", out, 0);

        write(out.toString());
    }


    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        digit = reader.readLine();
    }

    private static void write(String res) {
        System.out.println(res);
    }

    private static void createCombinations(String digit, String combination, StringBuilder res, int index) {
        if(index == digit.length()) {
            res.append(combination).append(" ");
            return;
        }

        for (char c: keys.get(digit.charAt(index)).toCharArray())
            createCombinations(digit, combination + c, res, index + 1);
    }
}
