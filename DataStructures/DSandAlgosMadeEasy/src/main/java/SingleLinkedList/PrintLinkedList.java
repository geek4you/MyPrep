package SingleLinkedList;

/**
 * Created by Pradeep on 3/30/15.
 */


/**
 * Print Linked List
 * Time: O(n)
 * Space : O(1)
 */
public class PrintLinkedList {

    public static void print(Node head){
        if(head==null)
            return;

        Node current = head;
        while(null!=current.next){
            System.out.print(current.data);
            System.out.print("-->");
            current = current.next;
        }
        System.out.print(current.data);
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        Node node4 = new Node(50);
        node.next=node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        print(node);

    }
}
