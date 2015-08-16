package Stacks;

/**
 * Created by Pradeep on 5/19/15.
 */

/**
 * link: http://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/
 * Design a stack with operations on middle element
 * How to implement a stack which will support following operations in O(1) time complexity?
 * 1) push() which adds an element to the top of stack.
 * 2) pop() which removes an element from top of stack.
 * 3) findMiddle() which will return middle element of the stack.
 * 4) deleteMiddle() which will delete the middle element.
 * Push and pop are standard stack operations.
 * <p>
 * The important question is, whether to use a linked list or array for implementation of stack?
 * <p>
 * Please note that, we need to find and delete middle element. Deleting an element from middle is not O(1) for array.
 * Also, we may need to move the middle pointer up when we push an element and move down when we pop().
 * In singly linked list, moving middle pointer in both directions is not possible.
 * <p>
 * The idea is to use Doubly Linked List (DLL). We can delete middle element in O(1) time by maintaining mid pointer.
 * We can move mid pointer in both directions using previous and next pointers.
 * <p>
 * Following is C implementation of push(), pop() and findMiddle() operations. Implementation of deleteMiddle() is left
 * as an exercise. If there are even elements in stack, findMiddle() returns the first middle element. For example,
 * if stack contains {1, 2, 3, 4}, then findMiddle() would return 2.
 */
public class MIddleElementOperations {

}
