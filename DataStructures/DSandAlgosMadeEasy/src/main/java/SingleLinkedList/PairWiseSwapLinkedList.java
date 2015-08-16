package SingleLinkedList;

/**
 * Created by Pradeep on 5/13/15.
 */

/**
 * Pairwise swap elements of a given linked list
 * Given a singly linked list, write a function to swap elements pairwise. For example, if the linked list is
 * 1->2->3->4->5 then the function should change it to 2->1->4->3->5, and if the linked list is 1->2->3->4->5->6
 * then the function should change it to 2->1->4->3->6->5.
 *
 * @link http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 */
public class PairWiseSwapLinkedList {
    public Node pairSwap(Node head) {
        if (null == head || null == head.next)
            return head;

        Node current = head;
        Node next = current.next;

        while (null != current && null != current.next) {
            int temp = current.data;
            current.data = next.data;
            next.data = temp;
            current = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        PairWiseSwapLinkedList pairWiseSwapLinkedList = new PairWiseSwapLinkedList();
        Node node = new Node(40);
        node = Push.push(node, 30);
        node = Push.push(node, 20);
        node = Push.push(node,10);
        PrintLinkedList.print(node);
        System.out.println();
        PrintLinkedList.print(pairWiseSwapLinkedList.pairSwap(node));

    }

}
