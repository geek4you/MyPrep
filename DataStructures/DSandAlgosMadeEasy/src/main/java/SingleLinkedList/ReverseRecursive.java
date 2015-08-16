package SingleLinkedList;

/**
 * Created by Pradeep on 3/30/15.
 */

/**
 * Recursive Reverse of Linked List.
 * Time: O(n)
 * Space: O(n)
 */
public class ReverseRecursive {
    public static Node reverse(Node head){
        // reverse of the null (empty list) is null
        if(null == head)
            return null;

        // reverse of one element list is itself
        if(null == head.next)
            return head;

        Node first = head;
        Node next = head.next;

        // reverse of an n-element list is reverse of the second element on followed by the first.
        first.next=null;

        // then we reverse everything from second element
        Node reversedList = reverse(next);

        // join two lists
        next.next = first;

        return  reversedList;

    }

    public static void main(String args[]){
        Node node = new Node(50);
        node =Push.push(node,40);
        node =Push.push(node,30);
        node = Push.push(node,20);
        node = Push.push(node,10);

        PrintLinkedList.print(reverse(null));
        PrintLinkedList.print(reverse(node));
    }
}
