package SingleLinkedList;

/**
 * Created by Pradeep on 3/30/15.
 */

/**
 * Copy Linked List
 * Time: O(n)
 */
public class CopyList {
    public static Node copyList(Node head){
        if(null==head)
            return null;

        Node current = head;
        Node copyListHead = new Node(head.data);
        Node temp = copyListHead;

        while(null!=current.next){
            temp.next = new Node(current.next.data);
            temp = temp.next;
            current=current.next;
        }
        return copyListHead;

    }

    public static void main(String[] args) {
        Node node = new Node(50);
        node =Push.push(node,40);
        node =Push.push(node,30);
        node = Push.push(node,20);
        node = Push.push(node,10);

        PrintLinkedList.print(copyList(node));
    }
}
