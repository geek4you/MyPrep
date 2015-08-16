package SingleLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pradeep on 5/11/15.
 */
public class DetectLoopInLinkedList {

    // using hashmap O(n)
    public boolean detect1(Node head) {
        if (null == head)
            return false;
        Map<Node, Integer> map = new HashMap<Node, Integer>();
        Node current = head;

        while (null != current) {
            if (map.containsKey(current))
                return true;

            map.put(current, 1);
            current = current.next;
        }
        return false;
    }

    // using Floyd’s Cycle-Finding Algorithm O(n)
    public boolean detect2(Node head) {
        if (null == head)
            return false;

        Node pointer1 = head;
        Node pointer2 = head;

        while (null != pointer2 && null != pointer1.next && null != pointer1.next.next) {
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;

            if (pointer1 == pointer2)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(20);
        node =Push.push(node,4);
        node =Push.push(node,15);
        node = Push.push(node,10);

        // create loop
        node.next.next.next.next = node;

        DetectLoopInLinkedList detect = new DetectLoopInLinkedList();
        System.out.printf("1: "+detect.detect1(node));
        System.out.println();
        System.out.println("2: "+detect.detect2(node));

    }
}
