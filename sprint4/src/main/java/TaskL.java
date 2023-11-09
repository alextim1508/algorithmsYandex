import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        String str = reader.readLine();
        int len = 10;

        int base = 539;
        long mod = 2147483648L;

        long[] powers = getPowers(str, base, mod);
        long[] prefixHashes = getPrefixHashes(str, base, mod);

        Set<Long> counters = new HashSet<>();
        Set<Long> counters2 = new HashSet<>();
        Map<Long, Integer> positions = new HashMap<>();

        Set<String> result = new TreeSet<>(String::compareTo);

        for (int i = 0; i <str.length() - len + 1; i++) {
            long hash = subHash(i, i + len-1, powers, prefixHashes, base, mod);

            if(counters.contains(hash)) {
                int position = positions.get(hash);

                boolean isEquals = true;
                for (int j = 0; j < len; j++) {
                    if(str.charAt(i+j) != str.charAt(position + j)) {
                        isEquals = false;
                        break;
                    }
                }
                if(isEquals) {
                    result.add(str.substring(i, i+len));
                } else {
                    //collision!
                    if(counters2.contains(hash)) {
                        result.add(str.substring(i, i+len));
                    } else {
                        counters2.add(hash);
                    }
                }
            } else {
                counters.add(hash);
                positions.put(hash, i);
            }
        }

        result.forEach(s -> out.append(s).append("\n"));

        System.out.println(out);
    }

    private static long[] getPowers(String arr, int a, long mod) {
        long[] powers = new long[arr.length()];
        powers[0] = a % mod;
        for (int i = 1; i < arr.length(); i++) {
            powers[i] =(powers[i-1] * a) % mod;
        }
        return powers;
    }

    private static long[] getPrefixHashes(String arr, int base, long mod) {
        long[] hashes = new long[arr.length() + 1];

        for (int i = 0; i < arr.length(); i++)
            hashes[i+1] = ((hashes[i]*base) % mod + arr.charAt(i)) % mod;
        return hashes;
    }


    private static long subHash(int l, int r, long[] powers, long[] prefixHashes, int base, long mod) {
        return (prefixHashes[r+1] + mod - prefixHashes[l]  * powers[r - l] % mod) % mod;
    }
}
