package SingleLinkedList;

/**
 * Created by Pradeep on 5/19/15.
 */

/**
 * Given two numbers represented by two lists, write a function that returns sum list.
 * The sum list is list representation of addition of two input numbers.
 * <p>
 * Example 1
 * <p>
 * Input:
 * First List: 5->6->3  // represents number 365
 * Second List: 8->4->2 //  represents number 248
 * Output
 * Resultant list: 3->1->6  // represents number 613
 * Example 2
 * <p>
 * Input:
 * First List: 7->5->9->4->6  // represents number 64957
 * Second List: 8->4 //  represents number 48
 * Output
 * Resultant list: 5->0->0->5->6  // represents number 65005
 *
 * sol: Traverse both lists. One by one pick nodes of both lists and add the values.
 * If sum is more than 10 then make carry as 1 and reduce sum. If one list has more elements than the other then
 * consider remaining values of this list as 0.
 */
public class AddTwoNumbers {
    public Node addNumbers(Node first, Node second) {
        if (null == first && null == second)
            return null;

        if (null == first)
            return second;

        if (null == second)
            return first;

        // result is head node of the resultant list
        Node result = null;
        Node prev = null;
        int carry = 0;
        int sum = 0;
        while (null != first || null != second) {

            // Calculate value of next digit in resultant list.
            // The next digit is sum of following things
            // (i)  Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);

            // update carry for next caluculation
            carry = sum >= 10 ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // Create a new node with sum as data
            Node temp = new Node(sum);

            // set to head if this is first node. else set to prev
            if(null == result)
                result = temp;
            else // If this is not the first node then connect it to the rest.
                prev.next = temp;

            // Set prev for next insertion
            prev = temp;

            // Move first and second pointers to next nodes
            if(null != first)
                first = first.next;
            if(null != second)
                second = second.next;

        }

        if(carry > 0)
            prev.next = new Node(carry);

        // return head of the resultant list
        return result;

    }

    public static void main(String[] args) {
        Node node = new Node(6);
        node =Push.push(node,4);
        node =Push.push(node,9);
        node =Push.push(node,5);
        node =Push.push(node,7);

        Node node1 = new Node(4);
        node1 =Push.push(node1,8);

        System.out.println("Number1: ");
        PrintLinkedList.print(node);
        System.out.println();
        System.out.println("Number2: ");
        PrintLinkedList.print(node1);
        System.out.println();
        System.out.println("Sum: ");
        PrintLinkedList.print(new AddTwoNumbers().addNumbers(node,node1));

    }

}
