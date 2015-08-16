package SingleLinkedList;

/**
 * Created by Pradeep on 5/18/15.
 */
public class DetectAndRemoveLoop {

    public Node removeLoop(Node loopNode, Node head) {
        if (null == head || null == loopNode)
            return head;

        Node ptr1 = loopNode;
        Node ptr2 = loopNode;
        // Count the number of nodes in loop
        int count = 0;
        while (ptr2.next != ptr1) {
            count++;
            ptr2 = ptr2.next;
        }

        System.out.println("Length of loop: " + count);
        // Fix one pointer to head
        ptr2 = head;
        // And the other pointer to count nodes after head
        ptr1 = head;
        while (count > 0) {
            ptr1 = ptr1.next;
            count--;
        }

        /*  Move both pointers at the same pace,
      they will meet at loop starting node */
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // go to the pointer of last node
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }

        /* Set the next node of the loop ending node
      to fix the loop */
        ptr2.next = null;

        return head;
    }

    // using Floyd’s Cycle-Finding Algorithm O(n)
    public boolean detect2(Node head) {
        if (null == head)
            return false;

        Node pointer1 = head;
        Node pointer2 = head;

        while (null != pointer2 && null != pointer1.next && null != pointer1.next.next) {
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;

            if (pointer1 == pointer2){
                PrintLinkedList.print(removeLoop(pointer1,head));
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(20);
        node =Push.push(node,4);
        node =Push.push(node,15);
        node = Push.push(node,10);

        // create loop
        node.next.next.next.next = node;
        System.out.println((new DetectAndRemoveLoop().detect2(node)));
    }
}
