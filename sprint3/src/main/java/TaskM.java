import java.io.*;
import java.util.StringTokenizer;

public class TaskM {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[Integer.parseInt(reader.readLine())];
        int[] b = new int[Integer.parseInt(reader.readLine())];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < b.length; i++) {
            b[i] =Integer.parseInt(tokenizer.nextToken());
        }

        double median = findMedianSortedArrays(a, b);

        if(median % (int)median == 0)
            System.out.println((int)median);
        else
            System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int index = len / 2;

        if (len % 2 == 1) {
            return getKth(arr1, 0, arr1.length, arr2, 0, arr2.length, index);
        } else {
            int a = getKth(arr1, 0, arr1.length, arr2, 0, arr2.length, index);
            int b = getKth(arr1, 0, arr1.length, arr2, 0, arr2.length, index - 1);
            return (a+b)/ 2.;
        }
    }


    private static int getKth(int[] a, int aL, int aR,
                              int[] b, int bL, int bR,
                              int index) {
        if(aL == aR)
            return b[bL+index];
        if(bL == bR)
            return a[aL+index];

        int midA = (aL+aR)/2;
        int midB = (bL+bR)/2;

        int lenA = midA - aL;
        int lenB = midB - bL;

        if(a[midA] <= b[midB]) {
            if(index <= lenA + lenB)
                return getKth( a, aL, aR,
                        b, bL, midB,
                        index);
            else
                return getKth( a, midA+1, aR,
                        b, bL, bR,
                        index-lenA-1);
        } else {
            if(index <= lenA + lenB)
                return getKth( a, aL, midA,
                        b, bL, bR,
                        index);
            else
                return getKth(
                        a, aL, aR,
                        b, midB+1, bR,
                        index-lenB-1);
        }
    }
}
