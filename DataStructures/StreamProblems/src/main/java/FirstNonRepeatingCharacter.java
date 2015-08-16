import java.util.Arrays;

/**
 * Created by chanumolu on 8/8/15.
 */

/*
 *
 * @link : http://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 * Find the first non-repeating character from a stream of characters
 *
 * Given a stream of characters,
 * find the first non-repeating character from stream. You need to tell the first non-repeating character in O(1) time at any moment.
 *
 * 1) Create an empty DLL. Also create two arrays inDLL[] and repeated[] of size 256.
inDLL is an array of pointers to DLL nodes. repeated[] is a boolean array,
repeated[x] is true if x is repeated two or more times, otherwise false.
inDLL[x] contains pointer to a DLL node if character x is present in DLL,
otherwise NULL.

2) Initialize all entries of inDLL[] as NULL and repeated[] as false.

3) To get the first non-repeating character, return character at head of DLL.

4) Following are steps to process a new character 'x' in stream.
a) If repeated[x] is true, ignore this character (x is already repeated two
or more times in the stream)
b) If repeated[x] is false and inDLL[x] is NULL (x is seen first time)
Append x to DLL and store address of new DLL node in inDLL[x].
c) If repeated[x] is false and inDLL[x] is not NULL (x is seen second time)
Get DLL node of x using inDLL[x] and remove the node. Also, mark inDLL[x]
as NULL and repeated[x] as true.


*/

    // TODO: correct mistakes
public class FirstNonRepeatingCharacter {

    public static void findFirstNonRepeatingChar(char[] stream) {

        // DLL
        Node head = null, tail = null;

        // inDLL[x] contains pointer to a DLL node if x is present in DLL.
        // If x is not present, then inDLL[x] is null
        Node[] inDLL = new Node[1000];
        Arrays.fill(inDLL, null);

        // repeated[x] is true if x is repeated two or more times. If x is
        // not seen so far or x is seen only once. then repeated[x] is false
        boolean[] repeated = new boolean[1000];
        Arrays.fill(repeated, false);

        // Let us consider following stream and see the process
        for (int i = 0; i < stream.length; i++) {
            char x = stream[i];

            System.out.println("Reading " + x + " from the stream !!");

            // We process this character only if it has not occurred or occurred
            // only once. repeated[x] is true if x is repeated twice or more.s
            if (!repeated[x]) {

                // If the character is not in DLL, then add this at the end of DLL.
                if (inDLL[x] == null) {
                    Node[] headTail = append(new Node[]{head, tail}, x);
                    head = headTail[0];
                    tail = headTail[1];
                    inDLL[x] = tail;
                }

                // if char is in inDLL , mark as repeated and remove from DLL
                if (inDLL[x] != null) {
                    repeated[x] = true;
                    Node[] headTail = delete(new Node[]{head, tail}, inDLL[x]);
                    head = headTail[0];
                    tail = headTail[1];
                    inDLL[x] = null;
                }

            }

            // Print the current first non-repeating character from stream
            if (null != head) {
                System.out.println("First non-repeating character so far is: " + head.data);

            }
        }

    }

    // A utility function to append a character x at the end of DLL.
    // Note that the function may change head and tail pointers, that
    // is why pointers to these pointers are passed.
    public static Node[] append(Node[] headTail, char x) {
        Node head = headTail[0];
        Node tail = headTail[1];

        if (null == head) {
            head = new Node(x);
            tail = head;
            return new Node[]{head, tail};
        }

        tail.next = new Node(x);
        tail.next.prev = tail;

        return new Node[]{head, tail};

    }

    // A utility function to append a character x at the end of DLL.
    // Note that the function may change head and tail pointers, that
    // is why pointers to these pointers are passed.
    public static Node[] delete(Node[] headTail, Node x) {
        Node head = headTail[0];
        Node tail = headTail[1];

        if (null == head)
            return headTail;

        if (head == x) {
            head = head.next;
        }
        if (tail == x) {
            tail = tail.prev;
        }

        if (x.next != null)
            x.next.prev = x.prev;
        if (x.prev != null)
            x.prev.next = x.next;

        return new Node[]{head, tail};
    }


    public static void main(String[] args) {

        String str = "geeksforgeeksandgeeksquizfor";
        char[] stream = str.toCharArray();
        findFirstNonRepeatingChar(stream);

    }

}

class Node {
    char data;
    Node prev;
    Node next;

    public Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}


