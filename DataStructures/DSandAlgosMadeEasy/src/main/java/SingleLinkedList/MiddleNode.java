package SingleLinkedList;

/**
 * Created by Pradeep on 5/7/15.
 */

/**
 * Find the middle node of the Linked List
 *
 */
public class MiddleNode {

    public static Node middleNode(Node head){
        // list has no elements
        if(null==head)
            return null;

        // list has only one element
        if(null==head.next)
            return head;

        // list has only two elements
        if(null==head.next.next)
            return head;

        Node slow = head, fast=head;
        while(null!=fast.next && null!=fast.next.next){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        Node node = new Node(40);
        node = Push.push(node, 30);
        node = Push.push(node, 20);
        node = Push.push(node, 10);
        System.out.println(middleNode(node));
    }
}
