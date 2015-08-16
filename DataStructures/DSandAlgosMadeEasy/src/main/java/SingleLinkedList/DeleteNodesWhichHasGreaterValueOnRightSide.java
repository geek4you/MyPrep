package SingleLinkedList;

/**
 * Created by Pradeep on 5/18/15.
 */

/**
 * Given a singly linked list, remove all the nodes which have a greater value on right side.
 * <p>
 * Examples:
 * a) The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. Note that 12, 10, 5 and 2 have
 * been deleted because there is a greater value on the right side.
 * <p>
 * When we examine 12, we see that after 12 there is one node with value greater than 12 (i.e. 15), so we delete 12.
 * When we examine 15, we find no node after 15 that has value greater than 15 so we keep this node.
 * When we go like this, we get 15->6->3
 * <p>
 * b) The list 10->20->30->40->50->60->NULL should be changed to 60->NULL. Note that 10, 20, 30, 40 and 50 have been
 * deleted because they all have a greater value on the right side.
 * <p>
 * c) The list 60->50->40->30->20->10->NULL should not be changed.
 * <p>
 * Sol: Reverse the linked list and try
 */
public class DeleteNodesWhichHasGreaterValueOnRightSide {

    public Node deleteGtRight(Node head) {
        if (null == head)
            return head;

        head = ReverseListIterative.reverse(head);

        Node current = head;
        int max = current.data;

        while (null != current.next) {
            if(max > current.next.data){
                Node temp = current.next;
                current.next = current.next.next;
                temp.next = null;
            }else{
                max = current.next.data;
                current = current.next;
            }
        }

        return ReverseListIterative.reverse(head);
    }

    public static void main(String[] args) {
        Node node = new Node(40);
        node = Push.push(node, 30);
        node = Push.push(node, 20);
        node = Push.push(node, 10);
        node = Push.push(node, 5);
        PrintLinkedList.print(node);
        System.out.println();
        PrintLinkedList.print(new DeleteNodesWhichHasGreaterValueOnRightSide().deleteGtRight(node));
    }
}
