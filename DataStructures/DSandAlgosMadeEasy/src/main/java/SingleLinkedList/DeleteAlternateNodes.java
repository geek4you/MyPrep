package SingleLinkedList;

/**
 * Created by Pradeep on 5/14/15.
 */
public class DeleteAlternateNodes {

    public Node deleteAlternateNodes(Node head) {
        if (head == null)
            return head;

        Node prev = head;
        Node current = head.next;
        boolean evenFlag = true;
        while (null != current) {
            if (evenFlag) {
                prev.next = current.next;
                current.next = null;
                current = prev.next;
                evenFlag = false;
            } else {
                prev = current;
                current = current.next;
                evenFlag = true;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        DeleteAlternateNodes delAltNodes = new DeleteAlternateNodes();
        Node node = new Node(40);
        node = Push.push(node, 30);
        node = Push.push(node, 20);
        node = Push.push(node, 10);
        node = Push.push(node, 5);
        PrintLinkedList.print(node);
        System.out.println();
        PrintLinkedList.print(delAltNodes.deleteAlternateNodes(node));
    }
}
