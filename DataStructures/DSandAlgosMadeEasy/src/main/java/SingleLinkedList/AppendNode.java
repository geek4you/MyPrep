package SingleLinkedList;

/**
 * Created by Pradeep on 3/30/15.
 */

/**
 * Append node at the end.
 * Time: O(n)
 * Space : O(1)
 */
public class AppendNode {

    public static Node append(Node head, int data){
        if(null==head)
            return new Node(data);

        Node current = head;
        while(null!=current.next){
            current = current.next;
        }

        current.next = new Node(data);

        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(40);
        node =Push.push(node,30);
        node =Push.push(node,20);
        node = Push.push(node,10);
        PrintLinkedList.print(append(node,50));
    }
}
