package SingleLinkedList;

/**
 * Created by Pradeep on 5/11/15.
 */

/**
 * METHOD 1 (Use a Stack)
 * A simple solution is to use a stack of list nodes. This mainly involves three steps.
 * 1) Traverse the given list from head to tail and push every visited node to stack.
 * 2) Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
 * 3) If all nodes matched, then return true, else false.
 * <p>
 * Time complexity of above method is O(n), but it requires O(n) extra space. Following methods solve this with constant extra space.
 * <p>
 * <p>
 * METHOD 2 (By reversing the list)
 * This method takes O(n) time and O(1) extra space.
 * 1) Get the middle of the linked list.
 * 2) Reverse the second half of the linked list.
 * 3) Check if the first half and second half are identical.
 * 4) Construct the original linked list by reversing the second half again and attaching it back to the first half
 * <p>
 * To divide the list in two halves, method 2 of this post is used.
 * When number of nodes are even, the first and second half contain exactly half nodes.
 * The challenging thing in this method is to handle the case when number of nodes are odd.
 * We don’t want the middle node as part of any of the lists as we are going to compare them for equality.
 * For odd case, we use a separate variable ‘midnode’.
 */
public class CheckLinkedListIsPalindrome {

    public boolean isPalendrome(Node head) {
        if (null == head)
            return false;

        return false;
    }

    public boolean compareLists(Node head1, Node head2) {
        if (null == head1 && null == head2)
            return true;

        if (null == head1 || null == head2)
            return false;

        Node temp1 = head1;
        Node temp2 = head2;

        while (null != temp1 && null != temp2) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else {
                return false;
            }
        }

        // check if both are empty
        return (null == temp1 && null == temp2);
    }

    public int length(Node head) {
        if (null == head)
            return 0;
        Node current = head;
        int count = 0;
        while (null != current) {
            current = current.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CheckLinkedListIsPalindrome ch = new CheckLinkedListIsPalindrome();
        Node node = new Node(40);
        node = Push.push(node, 20);
        node = Push.push(node, 30);
        node = Push.push(node, 20);
        node = Push.push(node, 40);
        System.out.println(ch.isPalendrome(node));
    }
}
