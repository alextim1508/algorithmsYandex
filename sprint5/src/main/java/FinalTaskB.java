public class FinalTaskB {

    public static void main(String[] args) {
        test();
    }

    public static Node remove(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.getValue())
            node.setLeft(remove(node.getLeft(), key));
        else if (key > node.getValue())
            node.setRight(remove(node.getRight(), key));
        else {
            Node left = node.getLeft();
            Node right = node.getRight();

            if (right == null)
                return left;

            Node min = findMin(right);

            min.setRight(removeMin(right));

            min.setLeft(left);

            return min;
        }
        return node;
    }

    private static Node findMin(Node node) {
        return node.getLeft() != null ? findMin(node.getLeft()) : node;
    }

    private static Node removeMin(Node node) {
        if (node.getLeft() == null)
            return node.getRight();

        node.setLeft(removeMin(node.getLeft()));
        return node;
    }

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);

        if(newHead.getValue() != 5)
            throw new RuntimeException("test is failed");

        if(newHead.getRight() != node5)
            throw new RuntimeException("test is failed");

        if(newHead.getRight().getValue() != 8)
            throw new RuntimeException("test is failed");
    }
}
