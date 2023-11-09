

public class FinalTaskA {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        System.out.println(6 == brokenSearch(arr, 5));
    }

    public static int brokenSearch(int[] arr, int k) {
        return binarySearch(arr, k, 0, arr.length-1);
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {

        if (right < left)
            return -1;

        int middle = left + (right - left) / 2;

        if (arr[middle] == target) {
            return middle;
        }

        boolean isSorted = arr[right] > arr[left];
        if (isSorted) {
            if (target < arr[middle])
                return binarySearch(arr, target, left, middle - 1);
            else
                return binarySearch(arr, target, middle + 1, right);
        } else {
            int leftResult = binarySearch(arr, target, left, middle - 1);
            int rightResult = binarySearch(arr, target, middle + 1, right);
            return leftResult != -1 ? leftResult : rightResult;
        }
    }
}