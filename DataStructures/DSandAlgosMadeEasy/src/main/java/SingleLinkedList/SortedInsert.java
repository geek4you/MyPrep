package SingleLinkedList;

/**
 * Created by Pradeep on 3/31/15.
 */

/**
 * Sorted Insert
 *
 * Time: O(n)
 * Space: O(1)
 */
public class SortedInsert {

    public static Node sortedInsert(Node head,int data){
        if(null==head)
            return new Node(data);

        Node current = head;

        while(current.next!=null && current.next.data < data){
            current=current.next;
        }

        Node node = new Node(data);
        node.next = current.next;
        current.next=node;

        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(50);
        node =Push.push(node,40);
        node = Push.push(node,20);
        node = Push.push(node,10);

        PrintLinkedList.print(sortedInsert(node,30));
    }
}
