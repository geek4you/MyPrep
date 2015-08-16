package SingleLinkedList;

/**
 * Created by Pradeep on 5/13/15.
 */

/**
 * Find the intersection point of two linked lists
 * @link http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 *
 * 1) Brute-force
 * 2) Mark-visited nodes (alter linked list)
 * 3) HashMap O(n+m) and O(n) if n>m
 * 4) Using lengths (find the length of two lists. Get difference of lists(say l). traverse the larger list l nodes and then
 * traverse and compare nodes in both lists.(starting from first node in list2)
 */
public class IntersectionPoint {

    // 4th method
    public void findIntersectionPoint(Node head1 , Node head2){
        if(null == head1 || null == head2)
            return ;

        int len1 = length(head1);
        int len2 = length(head2);

        int len = Math.abs(len1-len2);
        if(len1<len2) {
            intersectionUtility(len, head2, head1);
        }else{
            intersectionUtility(len,head1,head2);
        }
    }

    // first head is larger one
    public void intersectionUtility(int len , Node head1 , Node head2){
        if(null == head1 || null == head2)
            return;

        Node pointer1 = head1;
        Node pointer2 = head2;

        int count =0;
        while(count < len) {
            pointer1 = pointer1.next;
            count ++;
        }

        while(null != pointer1 && null != pointer2){
            if(pointer1 == pointer2){
                System.out.println("Intersection point : "+pointer1.data);
                return;
            }
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
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
        Node head1 = new Node(70);
        head1 = Push.push(head1, 60);
        head1 = Push.push(head1, 50);
        Node inter = head1;
        head1 = Push.push(head1, 40);
        head1 = Push.push(head1, 30);
        head1 = Push.push(head1, 20);
        head1 = Push.push(head1, 10);

        Node head2 = new Node(75);
        Node last = head2;
        head2 = Push.push(head2, 65);
        head2 = Push.push(head2, 55);
        head2 = Push.push(head2, 40);
        head2 = Push.push(head2, 35);
        head2 = Push.push(head2, 25);
        head2 = Push.push(head2, 15);
        last.next = inter;

        IntersectionPoint in = new IntersectionPoint();
        in.findIntersectionPoint(head1,head2);
    }
}
