public class TaskG {

    public static void main(String[] args) {
        test();
    }

    public static int maxResult = Integer.MIN_VALUE;

    private static int findBranchMax(Node node) {
        int branchMax = node.value;

        int leftMax = 0;
        int rightMax = 0;
        if (node.left != null) {
            leftMax = findBranchMax(node.left);
            branchMax = Math.max(branchMax, node.value + leftMax);
        }

        if (node.right != null) {
            rightMax = findBranchMax(node.right);
            branchMax = Math.max(branchMax, node.value + rightMax);
        }

        int nodeMax = Math.max(branchMax, leftMax + node.value + rightMax);
        maxResult = Math.max(maxResult, nodeMax);

        return branchMax;
    }

    public static int treeSolution(Node node) {
        findBranchMax(node);
        return maxResult;
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
        Node node1 = new Node(5, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(-3, node2, node1);
        Node node4 = new Node(2, null, null);
        Node node5 = new Node(2, node4, node3);
        if(treeSolution(node5) != 6)
            throw new RuntimeException("test is failed");

    }
}
