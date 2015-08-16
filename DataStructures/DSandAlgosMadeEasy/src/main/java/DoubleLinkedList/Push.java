package DoubleLinkedList;

/**
 * Created by Pradeep on 5/14/15.
 */

/* Function to insert a node at the beginning of the Doubly Linked List */
public class Push {
    public static Node push(Node head, int x){
        // check for empty dll
        if(null == head)
            return new Node(x);

        Node node = new Node(x);
        node.next = head;
        head.prev = node;
        return node;
    }

}
