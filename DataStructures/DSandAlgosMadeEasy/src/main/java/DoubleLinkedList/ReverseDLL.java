package DoubleLinkedList;

/**
 * Created by Pradeep on 5/13/15.
 */

/**
 * Reverse a Doubly Linked List
 * All we need to do is swap prev and next pointers for all nodes, change prev of the head
 * (or start) and change the head pointer in the end.
 *
 * @link http://www.geeksforgeeks.org/reverse-a-doubly-linked-list/
 */
public class ReverseDLL {
    public Node reverse(Node head) {
        if (null == head)
            return head;

        Node current = head;
        Node temp = null;

        /* swap next and prev for all nodes of
       doubly linked list */
        while (null != current){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like empty
        list and list with only one node */
        if(null != temp)
            head = temp.prev;

        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(50);
        node = Push.push(node,40);
        node = Push.push(node,30);
        node = Push.push(node,20);
        node = Push.push(node,10);

        System.out.print("DLL: ");
        PrintDLL.print(node);
        System.out.println();
        ReverseDLL reverseDLL = new ReverseDLL();
        PrintDLL.print(reverseDLL.reverse(node));
    }
}
