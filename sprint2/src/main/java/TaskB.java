public class TaskB {

    public static void main(String[] args) {
        test();
    }

    public static void solution(Node<String> node) {
        if(node != null) {
            System.out.println(node.value);
            solution(node.next);
        }
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
        solution(node0);
    }
}


