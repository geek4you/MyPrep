package SingleLinkedList;

/**
 * Created by Pradeep on 5/19/15.
 */

/**
 * Segregate even and odd nodes in a Linked List
 * Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear
 * before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.
 * <p>
 * Examples:
 * Input: 17->15->8->12->10->5->4->1->7->6->NULL
 * Output: 8->12->10->4->6->17->15->5->1->7->NULL
 * <p>
 * Input: 8->12->10->5->4->1->6->NULL
 * Output: 8->12->10->4->6->5->1->NULL
 * <p>
 * // If all numbers are even then do not change the list
 * Input: 8->12->10->NULL
 * Output: 8->12->10->NULL
 * <p>
 * // If all numbers are odd then do not change the list
 * Input: 1->3->5->7->NULL
 * Output: 1->3->5->7->NULL
 */
public class SegregateEvenOddNumbers {

    public Node segregate(Node head) {
        if (null == head)
            return null;

        Node evenList = null;
        Node prev1 = null;
        Node oddList = null;
        Node prev2 = null;
        Node current = head;

        while (null != current) {
            if (current.data % 2 == 0) { //even
                if (null == evenList) {
                    evenList = current;
                    current = current.next;
                    prev1 = evenList;
                    prev1.next = null;
                } else {
                    prev1.next = current;
                    current = current.next;
                    prev1 = prev1.next;
                    prev1.next = null;
                }
            } else { //odd
                if (null == oddList) {
                    oddList = current;
                    current = current.next;
                    prev2 = oddList;
                    prev2.next = null;
                } else {
                    prev2.next = current;
                    current = current.next;
                    prev2 = prev2.next;
                    prev2.next = null;
                }
            }
        }

        if (null != prev1) {
            prev1.next = oddList;
            return evenList;
        }else{
            return oddList;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(11);
        node =Push.push(node,10);
        node =Push.push(node,8);
        node = Push.push(node,6);
        node = Push.push(node,3);
        node = Push.push(node,2);
        node = Push.push(node,0);

        System.out.println("List: ");
        PrintLinkedList.print(node);
        System.out.println();
        System.out.println("Segregated list: ");
        PrintLinkedList.print(new SegregateEvenOddNumbers().segregate(node));

    }


}
