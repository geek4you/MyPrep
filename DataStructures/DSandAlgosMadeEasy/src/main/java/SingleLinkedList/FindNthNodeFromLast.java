package SingleLinkedList;

/**
 * Created by Pradeep on 5/11/15.
 */
public class FindNthNodeFromLast {

    public void findNnodeFromLast(Node head, int n) {
        if (null == head)
            throw new RuntimeException("Incorrect input.head is null!!");

        int len = length(head);
        if (len < n)
            throw new RuntimeException("Incorrect input.Length of list is less than n!!");

        Node pointer1 = head;
        Node pointer2 = head;

        int count = 0;
        while (count < n){
            pointer1 = pointer1.next;
            count++;
        }

        while (null!=pointer1){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        System.out.println("Nth Node from last: "+pointer2.data);

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
        FindNthNodeFromLast findNthNodeFromLast = new FindNthNodeFromLast();
        Node node = new Node(40);
        node =Push.push(node,20);
        node =Push.push(node,30);
        node = Push.push(node,10);
        node = Push.push(node,10);
        PrintLinkedList.print(node);
        System.out.println();
        findNthNodeFromLast.findNnodeFromLast(node, 1);
    }
}
