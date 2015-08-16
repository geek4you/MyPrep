package SingleLinkedList;

/**
 * Created by Pradeep on 5/20/15.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given two Linked Lists, create union and intersection lists that contain union and intersection of the elements
 * present in the given lists. Order of elments in output lists doesn’t matter.
 * <p>
 * Example:
 * <p>
 * Input:
 * List1: 10->15->4->20
 * lsit2:  8->4->2->10
 * Output:
 * Intersection List: 4->10
 * Union List: 2->8->20->4->15->10
 */
public class UnionAndIntersection {

    public Node intersection(Node head1, Node head2) {
        if (null == head1 || null == head2)
            return null;

        Node current = head1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (null != current) {
            map.put(current.data, 1);
            current = current.next;
        }

        // intersection list
        Node iL = null;
        Node prev = null;
        current = head2;
        while(null != current){
            if(map.containsKey(current.data)){
                if(null == iL){
                    iL = new Node(current.data);
                    prev = iL;
                    current = current.next;
                }else{
                    prev.next = new Node(current.data);
                    prev = prev.next;
                    current = current.next;
                }
            }else{
                current = current.next;
            }
        }

        return iL;

    }

    public Node union(Node head1, Node head2) {
        if(null == head1 && null == head2)
            return null;

        if(null == head1)
            return head2;

        if(null == head2)
            return head1;

        Node current = head1;

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        Node uL = null;
        Node prev = null;
        while(null != current){
            if(!map.containsKey(current.data)){
                map.put(current.data,1);
                if(null == uL){
                    uL = new Node(current.data);
                    prev = uL;
                    current = current.next;
                }else{
                    prev.next = new Node(current.data);
                    prev = prev.next;
                    current = current.next;
                }
            }else{
                current = current.next;
            }
        }

        current = head2;
        while(null != current){
            if(!map.containsKey(current.data)){
                map.put(current.data,1);
                if(null == uL){
                    uL = new Node(current.data);
                    prev = uL;
                    current = current.next;
                }else{
                    prev.next = new Node(current.data);
                    prev = prev.next;
                    current = current.next;
                }
            }else{
                current = current.next;
            }
        }

        return uL;
    }

    public static void main(String[] args) {
        Node node = new Node(20);
        node =Push.push(node,4);
        node =Push.push(node,15);
        node = Push.push(node,10);

        Node node1 = new Node(10);
        node1 =Push.push(node1,2);
        node1 =Push.push(node1,4);
        node1 =Push.push(node1,8);

        System.out.println("List 1:");
        PrintLinkedList.print(node);
        System.out.println();
        System.out.println("List 2:");
        PrintLinkedList.print(node1);
        System.out.println();
        System.out.println("Union: ");
        PrintLinkedList.print(new UnionAndIntersection().union(node, node1));
        System.out.println();
        System.out.println("Intersection: ");
        PrintLinkedList.print(new UnionAndIntersection().intersection(node,node1));

    }
}
