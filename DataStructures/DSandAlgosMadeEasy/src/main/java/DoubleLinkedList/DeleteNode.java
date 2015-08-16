package DoubleLinkedList;

/**
 * Created by Pradeep on 5/14/15.
 */

// Delete a node in a Doubly Linked List
// @link http://www.geeksforgeeks.org/delete-a-node-in-a-doubly-linked-list/
public class DeleteNode {
    public Node deleteNode(Node head, int x) {
        if (null == head)
            return head;

        // if x is first node
        if(head.data == x){
            Node temp = head.next;
            head.next = null;
            temp.prev = null;
            head = temp;
            return head;
        }

        System.out.println("x is not first node!!");
        // if x is middle node
        Node current = head.next;
        while(null != current.next){
            if(current.data == x){
                Node temp = current.next;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = null;
                current.next = null;
                current = temp;
            }else{
                current = current.next;
            }
        }

        // check if last node is x
        if(current.data == x){
            current.prev.next = null;
            current.prev = null;
        }

        return head;
    }

    public static void main(String[] args) {
        DeleteNode delNode = new DeleteNode();
        Node node = new Node(50);
        node = Push.push(node,40);
        node = Push.push(node,30);
        node = Push.push(node,20);
        node = Push.push(node,10);

        System.out.print("DLL: ");
        PrintDLL.print(node);
        System.out.println();
        PrintDLL.print(delNode.deleteNode(node,50));

    }
}
