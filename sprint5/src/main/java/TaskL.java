public class TaskL {

    public static void main(String[] args) {
        test();
    }

    public static int siftDown(int[] heap, int idx) {
        return heapify(heap, heap.length, idx);
    }

    private static int heapify(int[] array, int size, int node) {
        int largest  = node;
        int left = 2*node;
        int right = left + 1;

        if(right < size && array[right] > array[largest]) {
            largest = right;
        }
        if(left < size && array[left] > array[largest]) {
            largest = left;

        }
        if(largest != node) {
            swap(array, node, largest);
            return heapify(array, size, largest);
        } else {
            return largest;
        }
    }

    private static void swap(int[] a, int i1, int i2) {
        a[i1] = a[i1] + a[i2];
        a[i2] = a[i1] - a[i2];
        a[i1] = a[i1] - a[i2];
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        if(siftDown(sample, 2) != 5)
            throw new RuntimeException("test is failed");
    }
}