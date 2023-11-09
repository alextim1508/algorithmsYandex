import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskC {

    private static int base;
    private static int mod;
    private static int[][] ranges;
    private static String str;


    public static void main(String[] args) throws IOException {
        read();

        long[] prefixHashes = getPrefixHashes(str, base, mod);
        long[] powers = getPowers(str, base, mod);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < ranges.length; i++) {
            out.append(subHash(ranges[i][0]-1, ranges[i][1]-1, powers, prefixHashes, base, mod)).append("\n");
        }

        write(out.toString());
    }


    private static long[] getPowers(String str, int a, int mod) {
        long[] powers = new long[str.length()];
        powers[0] = a % mod;
        for (int i = 1; i < str.length(); i++) {
            powers[i] =(powers[i-1] * a) % mod;
        }
        return powers;
    }

    private static long[] getPrefixHashes(String str, int base, int mod) {
        long[] hashes = new long[str.length()+1];

        for (int i = 0; i < str.length(); i++)
            hashes[i+1] = ((hashes[i]*base) % mod + str.charAt(i)) % mod;
        return hashes;
    }

    private static long subHash(int l, int r, long[] powers, long[] prefixHashes, int base, int mod) {
        return (prefixHashes[r+1] + mod - prefixHashes[l]  * powers[r - l] % mod) % mod;
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        base = Integer.parseInt(reader.readLine());
        mod = Integer.parseInt(reader.readLine());
        str = reader.readLine();

        ranges = new int[Integer.parseInt(reader.readLine())][];
        for (int i = 0; i < ranges.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            ranges[i] = new int[2];
            ranges[i][0] = Integer.parseInt(tokenizer.nextToken());
            ranges[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(String hash) {
        System.out.println(hash);
    }

}
