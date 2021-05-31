package algorithm;

/**
 * @author: wangpeilei
 * @date: 2021/05/25 19:23
 **/
public class LinkedReverse {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node node1 = reverseLinkedList(node);
        System.out.println(1);
    }

    private static Node reverseLinkedList(Node header) {
        if (header == null || header.next == null) {
            return header;
        }
        Node preNode = new Node();
        preNode.next = header;

        Node q = header.next;

        while (q != null) {
            Node p = preNode.next;

            Node qNext = q.next;

            preNode.next = q;
            header.next = q.next;
            q.next = p;

            q = qNext;
        }

        return preNode.next;
    }

    private static class Node {
        private int i;

        private Node next;

        public Node() {
        }

        public Node(int i) {
            this.i = i;
        }
    }
}
