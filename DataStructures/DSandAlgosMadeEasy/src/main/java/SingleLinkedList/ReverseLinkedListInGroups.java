package SingleLinkedList;

/**
 * Created by Pradeep on 5/19/15.
 */

/**
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * <p>
 * Example:
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
 * Output:  3->2->1->6->5->4->8->7->NULL.
 * <p>
 * Inputs:   1->2->3->4->5->6->7->80->NULL and k = 5
 * Output:  5->4->3->2->1->8->7->6->NULL.
 * <p>
 * Algorithm: reverse(head, k)
 * 1) Reverse the first sub-list of size k. While reversing keep track of the next node and previous node.
 * Let the pointer to the next node be next and pointer to the previous node be prev.
 * 2) head->next = reverse(next, k) // Recursively call for rest of the list and link the two sub-lists
 * 3) return prev // prev becomes the new head of the list (see the diagrams of iterative method of this post)
 */
public class ReverseLinkedListInGroups {

    public Node reverse(Node head, int k) {
        if (null == head)
            return null;

        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;

        /*reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
       Recursively call for the list starting from current.
       And make rest of the list as next of first node */
        if(null != next)
        head.next = reverse(next,k);

        /* prev is new head of the input list */
        return prev;
    }

    public static void main(String[] args) {
        Node node = new Node(80);
        node =Push.push(node,70);
        node =Push.push(node,60);
        node = Push.push(node,50);
        node = Push.push(node,40);
        node = Push.push(node,30);
        node = Push.push(node,20);
        node = Push.push(node,10);

        PrintLinkedList.print(node);
        System.out.println();
        PrintLinkedList.print(new ReverseLinkedListInGroups().reverse(node,3));


    }
}
