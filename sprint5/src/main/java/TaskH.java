public class TaskH {

    public static void main(String[] args) {
        test();
    }

    public static int treeSolution(Node node, String value, int result) {
        if (node.left == null && node.right == null) {
            result += Integer.parseInt(value + node.value);
            return result;
        }

        if (node.left != null)
            result = treeSolution(node.left, value + node.value, result);

        if (node.right != null)
            result = treeSolution(node.right, value + node.value, result);

        return result;
    }

    public static int treeSolution(Node node) {
        return treeSolution(node, "", 0);
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
        Node node1 = new Node(2, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(2, null, null);
        Node node5 = new Node(1, node4, node3);
        if(treeSolution(node5) != 275)
            throw new RuntimeException("test is failed");

    }
}
