public class TaskB {

    public static void main(String[] args) {
        test();
    }

    public static boolean treeSolution(Node head) {
        if (head == null)
            return true;

        int lh = height(head.left);
        int rh = height(head.right);

        return Math.abs(lh - rh) <= 1 && treeSolution(head.left) && treeSolution(head.right);
    }

    private static int height(Node node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
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
    }

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        if(!treeSolution(node5))
            throw new RuntimeException("test is failed");
    }
}
