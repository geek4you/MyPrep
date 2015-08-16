package DoubleLinkedList;

/**
 * Created by Pradeep on 5/14/15.
 */
public class PrintDLL {

    public static void print(Node head) {
        if (null == head)
            return;

        Node current = head;
        while (null != current) {
            System.out.print(" <- " + current.data + " -> ");
            current = current.next;
        }
    }
}
