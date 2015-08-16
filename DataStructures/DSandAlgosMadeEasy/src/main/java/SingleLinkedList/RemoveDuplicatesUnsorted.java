package SingleLinkedList;

/**
 * Created by Pradeep on 5/7/15.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 1) Two loops compare (O(n^2))
 * 2) Sort  (O(n*log(n)) and then remove O(n)
 * 3) HashMap (O(n)) (assuming that hash table access time is O(1) on average).
 */
public class RemoveDuplicatesUnsorted {

    public static Node removeDuplicates(Node head){
        if(null==head || null == head.next)
            return head;

        Map<Integer,Integer> m = new HashMap<Integer, Integer>();
        Node current =head;
        Node temp = current;

        while(null != current) {
            if (!m.containsKey(current.data)) {
                m.put(current.data, 1);
                temp = current;
                current = current.next;

            } else {
                if (current.next != null) {
                    temp.next = current.next;
                    current.next = null;
                    current = temp.next;
                } else {
                    temp.next = null;
                }

            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(40);
        node =Push.push(node,50);
        node =Push.push(node,50);
        node = Push.push(node,50);
        node = Push.push(node,10);
        PrintLinkedList.print(node);
        System.out.println();
        PrintLinkedList.print(removeDuplicates(node));
    }
}
