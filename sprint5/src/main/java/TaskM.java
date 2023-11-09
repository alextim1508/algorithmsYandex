public class TaskM {

    public static void main(String[] args) {
        test();
    }

    public static int siftUp(int[] heap, int idx) {
        return heapify(heap, idx);
    }

    private static int heapify(int[] array, int node) {
        int parent  = node / 2;

        if(parent > 0 && array[parent] < array[node]) {
            swap(array, node, parent);
            return heapify(array, parent);
        } else {
            return node;
        }
    }

    private static void swap(int[] a, int i1, int i2) {
        a[i1] = a[i1] + a[i2];
        a[i2] = a[i1] - a[i2];
        a[i1] = a[i1] - a[i2];
    }

    private static void test() {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
        if(siftUp(sample, 5) != 1)
            throw new RuntimeException("test is failed");
    }
}