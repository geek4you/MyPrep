package SingleLinkedList;

/**
 * Created by Pradeep on 5/13/15.
 */

/**
 * Given a linked list of line segments, remove middle points
 * Given a linked list of co-ordinates where adjacent points either form a vertical line or a horizontal line. Delete points from the linked list which are in the middle of a horizontal or vertical line.
 * <p>
 * Examples:
 * <p>
 * Input:  (0,10)->(1,10)->(5,10)->(7,10)
 * |
 * (7,5)->(20,5)->(40,5)
 * Output: Linked List should be changed to following
 * (0,10)->(7,10)
 * |
 * (7,5)->(40,5)
 * The given linked list represents a horizontal line from (0,10)
 * to (7, 10) followed by a vertical line from (7, 10) to (7, 5),
 * followed by a horizontal line from (7, 5) to (40, 5).
 * <p>
 * Input:     (2,3)->(4,3)->(6,3)->(10,3)->(12,3)
 * Output: Linked List should be changed to following
 * (2,3)->(12,3)
 * There is only one vertical line, so all middle points are removed.
 * <p>
 * The idea is to keep track of current node, next node and next-next node. While the next node is same as next-next node,
 * keep deleting the next node. In this complete procedure we need to keep an eye on shifting of pointers and checking for
 * NULL values.
 */

// link : http://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/
    // Time : O(n)
public class LinkedListLineSegment {

    public LSNode deleteMiddle(LSNode head) {
        if (null == head || null == head.next || null == head.next.next)
            return head;

        LSNode next = head.next;
        LSNode nextNext = next.next;

        // check if vertical or horizontal
        if (head.x == next.x) {  // vertical
            // Find middle nodes with same x value, and delete them
            while (null != nextNext && next.x == nextNext.x) {
                head.next = nextNext;
                next.next = null;
                next = nextNext;
                nextNext = nextNext.next;
            }
        } else if (head.y == next.y) {  // horizontal
            // Find middle nodes with same y value, and delete them
            while (null != nextNext && next.y == nextNext.y) {
                head.next = nextNext;
                next.next = null;
                next = nextNext;
                nextNext = nextNext.next;
            }
        } else {
            throw new RuntimeException("Either x or y should be same for adjacent nodes!!");
        }

        next = deleteMiddle(head.next);

        return head;
    }

    public static void main(String[] args) {
        LSNode node = new LSNode(0,10);
        node.next = new LSNode(1,10);
        node.next.next = new LSNode(3,10);
        node.next.next.next = new LSNode(10,10);
        node.next.next.next.next = new LSNode(10,8);
        node.next.next.next.next.next = new LSNode(10,5);
        node.next.next.next.next.next.next = new LSNode(20,5);
        node.next.next.next.next.next.next.next = new LSNode(40,5);

        LinkedListLineSegment ls = new LinkedListLineSegment();

        ls.print(ls.deleteMiddle(node));
    }

    void print(LSNode head){
        if(null == head)
            return ;
        LSNode current = head;
        while(null != current){
            System.out.print(current);
            current = current.next;
        }

    }


}

class LSNode {

    int x, y;
    LSNode next;

    public LSNode(int x, int y) {
        this.x = x;
        this.y = y;
        this.next = null;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")->";
    }
}
