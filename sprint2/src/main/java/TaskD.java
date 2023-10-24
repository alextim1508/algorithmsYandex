public class TaskD {

    public static void main(String[] args) {
        test();
    }

    private static int id = 0;

    public static int solution(Node<String> node, String elem) {
        if(node == null)
            return -1;

        if(node.value.equals(elem))
            return id;

        id++;
        return solution(node.next, elem);
    }

    private static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node2");
        System.out.println("idx = " + idx);
    }
}
