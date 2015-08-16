package DoubleLinkedList;

/**
 * Created by Pradeep on 5/12/15.
 */
public class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
