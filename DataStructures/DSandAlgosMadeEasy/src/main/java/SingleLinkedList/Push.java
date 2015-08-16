package SingleLinkedList;

/**
 * Created by Pradeep on 3/30/15.
 */

/**
 * Add a node at the beginning of the list.
 * Time: O(1)
 * Space: O(1)
 */
public class Push {
    public static Node push(Node head, int data){
        if(null==head)
            return new Node(data);

        Node newNode = new Node(data);
        newNode.next=head;
        return newNode;
    }

    public static Node pushNode(Node head, Node node){
        if(null == head && null == node)
            return null;

        if(null == node)
            return head;

        node.next = head;
        head = node;

        return head;

    }

    public static void main(String[] args) {
        PrintLinkedList.print(push(null,10));
        System.out.println();
        Node node = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        Node node4 = new Node(50);
        node.next=node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        PrintLinkedList.print(push(node,5));
    }
}
