import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskI {

    private static int[] arr1;
    private static int[] arr2;

    public static void main(String[] args) throws IOException {
        read();

        int base = 51379;
        long mod = 2147483648L;

        long[] powers = getPowers(arr1.length < arr2.length ? arr1 : arr2, base, mod);
        long[] prefixHashes1 = getPrefixHashes(arr1, base, mod);
        long[] prefixHashes2 = getPrefixHashes(arr2, base, mod);

        int leftWindowLen = 1;
        int rightWindowLen = Math.min(arr1.length, arr2.length);

        int maxLen = 0;
        while (leftWindowLen <= rightWindowLen) {
            int middle = (leftWindowLen + rightWindowLen) / 2;

            if (checkCollision(prefixHashes1, prefixHashes2, middle, powers, base, mod)) {
                maxLen = middle;
                leftWindowLen = middle + 1;
            } else {
                rightWindowLen = middle - 1;
            }
        }

        write(maxLen);
    }

    private static boolean checkCollision(long[] prefixHashes1, long[] prefixHashes2, int windowLen, long[] powers, int base, long mod) {
        Set<Long> hashes = new HashSet<>();

        for (int i = 0; i < prefixHashes1.length - windowLen; i++)
            hashes.add(subHash(i, i + windowLen - 1, powers, prefixHashes1, base, mod));

        for (int i = 0; i < prefixHashes2.length - windowLen; i++)
            if (hashes.contains(subHash(i, i + windowLen - 1, powers, prefixHashes2, base, mod)))
                return true;
        return false;
    }

    private static long[] getPowers(int[] arr, int a, long mod) {
        long[] powers = new long[arr.length];
        powers[0] = a % mod;
        for (int i = 1; i < arr.length; i++) {
            powers[i] = (powers[i - 1] * a) % mod;
        }
        return powers;
    }

    private static long[] getPrefixHashes(int[] arr, int base, long mod) {
        long[] hashes = new long[arr.length + 1];

        for (int i = 0; i < arr.length; i++)
            hashes[i + 1] = ((hashes[i] * base) % mod + arr[i]) % mod;
        return hashes;
    }

    private static long subHash(int l, int r, long[] powers, long[] prefixHashes, int base, long mod) {
        return (prefixHashes[r + 1] + mod - prefixHashes[l] * powers[r - l] % mod) % mod;
    }

    private static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        arr1 = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(tokenizer.nextToken());
        }
        arr2 = new int[Integer.parseInt(reader.readLine())];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void write(int maxLen) {
        System.out.println(maxLen);
    }
}
