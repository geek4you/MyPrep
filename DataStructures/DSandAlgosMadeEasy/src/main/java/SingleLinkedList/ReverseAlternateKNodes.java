package SingleLinkedList;

/**
 * Created by Pradeep on 5/19/15.
 */

/**
 * Reverse alternate K nodes in a Singly Linked List
 * Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) in an
 * efficient way. Give the complexity of your algorithm.
 * <p>
 * Example:
 * Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
 * Output:   3->2->1->4->5->6->9->8->7->NULL.
 */
public class ReverseAlternateKNodes {

    public Node reverse(Node head, int k) {
        if (null == head)
            return null;

        Node current = head;
        Node prev = null;
        Node next = null;

        int count = 0;
        while (null != current && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(null != current)
            head.next = current;

        count =0;
        while (null != current && count < k-1) {
            current = current.next;
            count++;
        }

        if (current != null) {
            current.next = reverse(current.next, k);
        }

        return prev;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node = Push.push(node, 20);
        node = Push.push(node, 30);
        node = Push.push(node, 40);
        node = Push.push(node, 50);
        node = Push.push(node, 60);
        node = Push.push(node, 70);
        node = Push.push(node, 80);
        node = Push.push(node, 90);
        node = Push.push(node, 100);

        PrintLinkedList.print(node);
        System.out.println();
        PrintLinkedList.print(new ReverseAlternateKNodes().reverse(node, 3));
    }
}
