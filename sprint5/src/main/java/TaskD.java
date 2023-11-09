public class TaskD {

    public static void main(String[] args) {
        test();
    }

    public static boolean treeSolution(Node head1, Node head2) {
        return isTwins(head1, head2);
    }

    private static boolean isTwins(Node left, Node right) {
        if (left == null || right == null)
            return left == null && right == null;

        return left.value == right.value
                && isTwins(left.left, right.left)
                && isTwins(left.right, right.right);
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
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(1, null, null);
        Node node5 = new Node(2, null, null);
        Node node6 = new Node(3, node4, node5);
        if(!treeSolution(node3, node6))
            throw new RuntimeException("test is failed");
    }
}
