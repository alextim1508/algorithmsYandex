public class TaskC {

    public static void main(String[] args) {
        test();
    }

    public static Node<String> solution(Node<String> node, int id) {
        Node<String> head = node;

        if(id == 0)
            return head.next;

        while (--id != 0) {
            node = node.next;
        }

        node.next = node.next.next;

        return head;
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
        Node<String> newHead = solution(node0, 1);

        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }
    }
}
