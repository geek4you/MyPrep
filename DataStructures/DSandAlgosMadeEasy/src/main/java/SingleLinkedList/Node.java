package SingleLinkedList;

/**
 * Created by Pradeep on 3/30/15.
 */
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "node.data:"+data;
    }
}
