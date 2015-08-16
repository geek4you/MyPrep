package SingleLinkedList;

/**
 * Created by Pradeep on 5/7/15.
 */

/**
 * Given a list, split it into two sublists — one for the front half, and one for the back half. If
 the number of elements is odd, the extra element should go in the front list. So
 FrontBackSplit() on the list {2, 3, 5, 7, 11} should yield the two lists {2, 3, 5} and {7,11}.
 Getting this right for all the cases is harder than it looks. You will probably need special case
 code to deal with the (length <2) cases.
 */

/**
 * Time : O(n)
 * Space : O(1)
 */
public class FrontBackSplit {

    public static void frontBackSplit(Node head){

        if(null == head)
         return;

        if(null == head.next){
            System.out.println("List 1:");
            PrintLinkedList.print(head);
            return;
        }


        Node head2;
        if(null == head.next.next){
            head2 = head.next;
            head.next=null;
            System.out.println("List 1:");
            PrintLinkedList.print(head);
            System.out.println();
            PrintLinkedList.print(head2);
            return;
        }

        Node slow = head,fast = head;

        while(null!=fast.next && null!=fast.next.next){
            fast = fast.next.next;
            slow = slow.next;
        }

        head2 = slow.next;
        slow.next = null;

        System.out.println("List 1:");
        PrintLinkedList.print(head);
        System.out.println();
        System.out.println("List 2:");
        PrintLinkedList.print(head2);

    }

    public static void main(String[] args) {
        Node node = new Node(50);
        node =Push.push(node,40);
        node =Push.push(node,30);

        frontBackSplit(node);

    }
}
