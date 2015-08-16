package SingleLinkedList;

/**
 * Created by Pradeep on 5/14/15.
 */

/**
 * Alternating split of a given Singly Linked List
 * Write a function AlternatingSplit() that takes one list and divides up its nodes to make two smaller lists ‘a’ and ‘b’.
 * The sublists should be made from alternating elements in the original list. So if the original list is 0->1->0->1->0->1
 * then one sublist should be 0->0->0 and the other should be 1->1->1
 *
 * @link http://www.geeksforgeeks.org/alternating-split-of-a-given-singly-linked-list/
 */
public class AlternatingSplit {
    public void alternateSplit(Node head) {
        if (null == head || null == head.next)
            return;

        Node current = head.next.next;
        Node head1 = head;
        Node head2 = head.next;
        head1.next = null;
        head2.next = null;
        boolean first = true;
        while (current != null) {
            if (first) {
                Node temp = current.next;
                current.next = null;
                head1 = Push.pushNode(head1, current);
                first = false;
                current = temp;
            } else {
                Node temp = current.next;
                current.next = null;
                head2 = Push.pushNode(head2, current);
                first = true;
                current = temp;
            }
        }

        head1 = ReverseListIterative.reverse(head1);
        head2 = ReverseListIterative.reverse(head2);

        System.out.println("List1: ");
        PrintLinkedList.print(head1);
        System.out.println();
        System.out.println("List2: ");
        PrintLinkedList.print(head2);
    }

    public static void main(String[] args) {
        Node node = new Node(40);
        node = Push.push(node, 30);
        node = Push.push(node, 20);
        node = Push.push(node, 10);
        node = Push.push(node, 5);
        PrintLinkedList.print(node);
        System.out.println();
        AlternatingSplit altSplit = new AlternatingSplit();
        altSplit.alternateSplit(node);
    }
}
