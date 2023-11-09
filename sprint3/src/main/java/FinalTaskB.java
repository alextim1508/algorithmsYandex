import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FinalTaskB {

    public static class Member implements Comparable<Member> {

        public final String login;
        public final int success;
        public final int failure;

        public Member(String login, int success, int failure) {
            this.login = login;
            this.success = success;
            this.failure = failure;
        }

        public int compareTo(Member other) {
            int result = Integer.compare(this.success, other.success);
            if(result == 0) {
                result = Integer.compare(this.failure, other.failure);
                if(result == 0) {
                    return -this.login.compareTo(other.login);
                } else {
                    return -result;
                }
            } else {
                return result;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Member[] members = read();

        quickSort(members, 0, members.length - 1);

        write(members);
    }

    public static void quickSort(Member[] arr, int left, int right) {
        if (arr.length == 0)
            return;

        if (left >= right)
            return;

        int middle = (left + right) / 2;
        Member pivot = arr[middle];

        int l = left, r = right;
        while (l <= r) {

            while (arr[l].compareTo(pivot) > 0) {
                l++;
            }

            while (arr[r].compareTo(pivot) < 0) {
                r--;
            }

            if (l <= r) {
                swap(arr, l++, r--);
            }
        }

        if (left < r)
            quickSort(arr, left, r);

        if (right > l)
            quickSort(arr, l, right);
    }

    private static void swap(Member[] arr, int i1, int i2) {
        Member temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private static Member[] read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Member[] members  = new Member[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < members.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String login = tokenizer.nextToken();
            int score = Integer.parseInt(tokenizer.nextToken());
            int fine = Integer.parseInt(tokenizer.nextToken());
            members[i] = new Member(login, score, fine);
        }
        return members;
    }

    private static void write(Member[] members) {
        StringBuilder out = new StringBuilder();
        for (Member p : members)
            out.append(p.login).append(System.lineSeparator());
        System.out.println(out);
    }
}
