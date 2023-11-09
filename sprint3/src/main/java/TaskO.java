import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskO {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int[] arr = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(arr);
        int k = Integer.parseInt(reader.readLine());


        int left = 0;
        int right = arr[arr.length -1] - arr[0];
        while (left < right) {
            int mid = (left + right)/2;
            if(checkIndex(arr, mid, k))
                right = mid;
            else
                left = mid + 1;
        }

        System.out.println(left);
    }

    private static boolean checkIndex(int[] arr, int pos, int k) {
        int left = 0;
        int count = 0;
        for (int right = 0; right < arr.length; right++) {
            while (arr[right] - arr[left] > pos)
                left++;
            count += right - left;
        }
        return count >= k;
    }

}
