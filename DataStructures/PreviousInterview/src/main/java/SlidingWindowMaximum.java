import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chanumolu on 8/3/15.
 */


/*

@link : http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/

Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
Input :
a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6
*/

/*
Solution1 : Brute Force
    Run two loops. In the outer loop, take all subarrays of size k. In the inner loop,
    get the maximum of the current subarray.

Solution2: Use Max-Heap/ BST O(nlogk)
1) Pick first k elements and create a Self-Balancing Binary Search Tree (BST) of size k.
2) Run a loop for i = 0 to n – k
…..a) Get the maximum element from the BST, and print it.
…..b) Search for arr[i] in the BST and delete it from the BST.
…..c) Insert arr[i+k] into the BST.

Time Complexity: Time Complexity of step 1 is O(kLogk).
Time Complexity of steps 2(a), 2(b) and 2(c) is O(Logk).
Since steps 2(a), 2(b) and 2(c) are in a loop that runs n-k+1 times, time complexity of the complete algorithm is
 O(kLogk + (n-k+1)*Logk) which can also be written as O(nLogk).

Solution3:
O(n) method: use Dequeue

We create a Dequeue, Qi of capacity k, that stores only useful elements of current window of k elements.
An element is useful if it is in current window and is greater than all other elements on left side of it
in current window. We process all array elements one by one and maintain Qi to contain useful elements of current
window and these useful elements are maintained in sorted order. The element at front of the Qi is the largest and
element at rear of Qi is the smallest of current window.
*/
public class SlidingWindowMaximum {

    public static void maxSliding1(int[] arr, int n, int k) {
        int j, max;

        for (int i = 0; i <= n - k; i++) {
            max = arr[i];

            for (j = 1; j < k; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.println(max);
        }
    }

    // A Dequeue (Double ended queue) based method for printing maixmum element of
    // all subarrays of size k
    public static int[] windowMax(int[] arr, int k){

        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> deque = new LinkedList<Integer>();

        // return array
        int[] maxArray = new int[arr.length-k+1];
        /* Process first k (or first window) elements of array */
        for(int i=0; i<k ;i++){
            while(!deque.isEmpty() && arr[i]>arr[deque.peekLast()]){
                deque.removeLast();
            }
            // Add new element at rear of queue
            deque.add(i);
        }

        maxArray[0] = deque.peekFirst();

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (int i = k; i < arr.length; i++) {

            // Remove the elements which are out of this window
            while ( (!deque.isEmpty()) && deque.peekFirst() <= i - k)
                deque.removeFirst();  // Remove from front of queue

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while(!deque.isEmpty() && arr[i]>arr[deque.peekLast()]){
                deque.removeLast();
            }

            deque.add(i);
            maxArray[i-k+1] = deque.peekFirst(); // first element will be the max;
        }
        return maxArray;

    }

    /**
     * from leetcode : http://articles.leetcode.com/2011/01/sliding-window-maximum.html
     *
     * The double-ended queue is the perfect data structure for this problem. It supports insertion/deletion from
     * the front and back. The trick is to find a way such that the largest element in the window would always
     * appear in the front of the queue. How would you maintain this requirement as you push and pop elements in
     * and out of the queue?

     Besides, you might notice that there are some redundant elements in the queue that we shouldn’t even consider
     about. For example, if the current queue has the elements: [10 5 3], and a new element in the window has the
     element 11. Now, we could have emptied the queue without considering elements 10, 5, and 3, and insert only
     element 11 into the queue.

     A natural way most people would think is to try to maintain the queue size the same as the window’s size.
     Try to break away from this thought and try to think outside of the box. Removing redundant elements and
     storing only elements that need to be considered in the queue is the key to achieve the efficient O(n)
     solution below.
     */

    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        int[] res = windowMax(arr,3);
        for(int i : res){
            System.out.print(arr[i]+" ");
        }
    }
}
