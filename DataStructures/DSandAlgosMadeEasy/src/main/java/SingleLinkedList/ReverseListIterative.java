package SingleLinkedList;

/**
 * Created by Pradeep on 3/30/15.
 */

/**
 * Iteratively Reverse the linked list.
 * Time : O(n)
 * Space : O(1)
 */
public class ReverseListIterative {
    public static Node reverse(Node head){
        if(null==head)
            return null;

        Node previous = head;
        Node current = head;
        Node next = current.next;

        while(current.next!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        current.next = previous;
        head.next = null;

        return current;
    }

    public static void main(String[] args) {
        Node node = new Node(50);
        node =Push.push(node,40);
        node =Push.push(node,30);
        node = Push.push(node,20);
        node = Push.push(node,10);

        PrintLinkedList.print(reverse(node));
    }
}
