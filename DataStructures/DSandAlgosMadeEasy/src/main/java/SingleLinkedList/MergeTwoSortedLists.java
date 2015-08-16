package SingleLinkedList;

/**
 * Created by Pradeep on 5/19/15.
 */

// link : http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
public class MergeTwoSortedLists {

    public Node merge(Node head1, Node head2) {
        if (null == head1 && null == head2)
            return null;

        if (null == head1)
            return head2;
        else if (null == head2)
            return head1;

        Node head3 = null;
        Node tail3 = null;

        Node current1 = head1;
        Node current2 = head2;

        while (null != current1 && null != current2) {
            if (current1.data < current2.data) {
                if (null == tail3) {
                    head3 = current1;
                    current1 = current1.next;
                    tail3 = head3;
                    tail3.next = null;
                } else {
                    tail3.next = current1;
                    current1 = current1.next;
                    tail3 = tail3.next;
                    tail3.next = null;
                }
            } else {
                if (null == tail3) {
                    head3 = current2;
                    current2 = current2.next;
                    tail3 = head3;
                    tail3.next = null;
                } else {
                    tail3.next = current2;
                    current2 = current2.next;
                    tail3 = tail3.next;
                    tail3.next = null;
                }
            }
        }

        // if only head2 is empty
        if (null != current1) {
            tail3.next = current1;
        }

        //if only head1 is empty
        if (null != current2) {
            tail3.next = current2;
        }

        return head3;
    }

    public static void main(String[] args) {
        Node node = new Node(50);
        node =Push.push(node,30);
        node = Push.push(node,10);

        Node node1 = new Node(40);
        node1 = Push.push(node1,20);
        node1 = Push.push(node1,5);
        node1 = Push.push(node1,3);

        PrintLinkedList.print(node);
        System.out.println();
        PrintLinkedList.print(node1);
        System.out.println();
        PrintLinkedList.print(new MergeTwoSortedLists().merge(node,node1));
    }
}
