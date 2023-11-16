import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FinalTaskA {
    private static String[] strings;

    public static void main(String[] args) throws IOException {
        read();

        int len = Integer.MAX_VALUE;

        for (int i = 0; i < strings.length; i++) {
            strings[i] = unpackString(strings[i], 0).str;
            len = Math.min(strings[i].length(), len);
        }

        write(getMaxPrefix(strings, len));
    }

    public static UnpackedSubString unpackString(String str, int index) {
        StringBuilder builder = new StringBuilder();
        int multiplier = 0;

        for (int i = index; i < str.length(); i++) {
            char symbol = str.charAt(i);

            if (Character.isDigit(symbol)) {
                multiplier = Character.getNumericValue(symbol);

            } else if (Character.isLowerCase(symbol)) {
                builder.append(symbol);

            } else if (symbol == '[') {
                UnpackedSubString s = unpackString(str, i + 1);
                while (multiplier-- != 0)
                    builder.append(s.str);
                i = s.index;

            } else if (symbol == ']') {
                return new UnpackedSubString(builder.toString(), i);
            }
        }

        return new UnpackedSubString(builder.toString(), str.length() - 1);
    }

    public static String getMaxPrefix(String[] strings, int length) {
        StringBuilder maxPrefix = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char symbol = strings[0].charAt(i);

            boolean isPrefixFounded = false;
            for (int j = 1; j < strings.length; j++) {
                if (strings[j].charAt(i) != symbol) {
                    isPrefixFounded = true;
                    break;
                }
            }

            if (isPrefixFounded)
                break;
            else
                maxPrefix.append(symbol);
        }
        return maxPrefix.toString();
    }

    public static class UnpackedSubString {
        public String str;
        public int index;

        public UnpackedSubString(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        strings = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = reader.readLine();
        }
    }

    private static void write(String maxPrefix) {
        System.out.println(maxPrefix);
    }
}
