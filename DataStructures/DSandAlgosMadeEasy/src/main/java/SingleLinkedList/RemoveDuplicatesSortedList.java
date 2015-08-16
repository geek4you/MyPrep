package SingleLinkedList;

/**
 * Created by Pradeep on 4/1/15.
 */
public class RemoveDuplicatesSortedList {

    public static Node removeDuplicates(Node head){
        if(null==head)
            return head;
        if(null==head.next)
            return head;

        Node current = head;
        Node next = current.next;

        while(null!=next){
            if(current.data==next.data){
                current.next = next.next;
                next.next =null;
            }
            current=next;
            next=current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(40);
        node =Push.push(node,20);
        node =Push.push(node,20);
        node = Push.push(node,10);
        node = Push.push(node,10);
        PrintLinkedList.print(node);
        System.out.println();
        PrintLinkedList.print(removeDuplicates(node));
    }
}
