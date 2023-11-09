public class TaskE {

    public static void main(String[] args) {
        test();
    }

    public static boolean treeSolution(Node head) {
        return treeSolution(head, 0, 6000);
    }

    public static boolean treeSolution(Node head, int min, int max) {
        if (head == null)
            return true;

        if (head.value < min || head.value > max)
            return false;

        return treeSolution(head.left, min, head.value - 1) && treeSolution(head.right, head.value + 1, max);
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);

        if (!treeSolution(node5))
            throw new RuntimeException("test is failed");

        node2.value = 5;

        if (treeSolution(node5))
            throw new RuntimeException("test is failed");
    }
}
