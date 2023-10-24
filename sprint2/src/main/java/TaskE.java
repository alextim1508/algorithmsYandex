public class TaskE {

    public static void main(String[] args) {
        test();
    }

    public static Node<String> solution(Node<String> node) {

        Node<String> temp = node.next;
        node.next = node.prev;
        node.prev = temp;

        if (node.prev == null)
            return node;

        return solution(node.prev);
    }

    private static class Node<V> {
        public V value;
        public Node<V> next;
        public Node<V> prev;

        public Node(V value, Node<V> next, Node<V> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null, null);
        Node<String> node2 = new Node<>("node2", node3, null);
        Node<String> node1 = new Node<>("node1", node2, null);
        Node<String> node0 = new Node<>("node0", node1, null);
        Node<String> newNode = solution(node0);
        while (newNode != null) {
            System.out.println(newNode.value);
            newNode = newNode.next;
        }
    }
}
