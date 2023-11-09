`import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FinalTaskA {

    public static class InputData {
        public Member[] members;

        public InputData(Member[] members) {
            this.members = members;
        }
    }

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
                result = -Integer.compare(this.failure, other.failure);
            }
            if(result == 0) {
                result = -this.login.compareTo(other.login);
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData input = read();

        Member[] result = heapSort(input.members);

        write(result);
    }

    private static Member[] heapSort(Member[] members) {

        Member[] heap = new Member[members.length + 1];
        for (int i = 0; i < members.length; i++) {
            addToHeap(heap, i, members[i]);
        }

        for (int i = 0; i < heap.length - 1; i++) {
            Member min = popMin(heap, heap.length - 1 - i);
            heap[heap.length - 1 - i] = min;
        }

        return heap;
    }

    private static void addToHeap(Member[] heap, int heapSize, Member key){
        int index = heapSize + 1;
        heap[index] = key;
        siftUp(heap, index);
    }

    private static void siftUp(Member[] heap, int index) {
        if(index == 1)
            return;

        int parentIndex = index / 2;
        if(heap[index].compareTo(heap[parentIndex]) < 0) {
            swap(heap, index, parentIndex);
            siftUp(heap, parentIndex);
        }
    }

    private static Member popMin(Member[] heap, int heapSize) {
        Member result = heap[1];
        heap[1] = heap[heapSize];

        siftDown(heap, heapSize, 1);

        return result;
    }

    private static void siftDown(Member[] heap, int heapSize, int index){
        int leftIndex = 2 * index;
        int rightIndex = leftIndex + 1;

        if(heapSize < leftIndex)
            return;

        int indexSmallest;
        if (rightIndex <= heapSize && heap[leftIndex].compareTo(heap[rightIndex]) > 0)
            indexSmallest = rightIndex;
        else
            indexSmallest = leftIndex;

        if(heap[index].compareTo(heap[indexSmallest]) > 0) {
            swap(heap, index, indexSmallest);
            siftDown(heap, heapSize, indexSmallest);
        }
    }
    
    private static void swap(Member[] a, int i1, int i2) {
        Member temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Member[] members  = new Member[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < members.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String login = tokenizer.nextToken();
            int score = Integer.parseInt(tokenizer.nextToken());
            int fine = Integer.parseInt(tokenizer.nextToken());
            members[i] = new Member(login, score, fine);
        }
        return new InputData(members);
    }

    private static void write(Member[] members) {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i < members.length; i++) {
            out.append(members[i].login).append(System.lineSeparator());
        }
        System.out.println(out);
    }
}

