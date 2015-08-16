/**
 * Created by chanumolu on 6/15/15.
 */

/**
 * @link: http://www.geeksforgeeks.org/majority-element/
 * <p>
 * Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times
 * (and hence there is at most one such element).
 * <p>
 * Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:
 * <p>
 * I/P : 3 3 4 2 4 4 2 4 4
 * O/P : 4
 * <p>
 * I/P : 3 3 4 2 4 4 2 4
 * O/P : NONE
 * <p>
 * This is a two step process.
 * 1. Get an element occurring most of the time in the array. This phase will make sure that if there is a majority element
 * then it will return that only.
 * 2. Check if the element obtained from above step is majority element.
 * <p>
 * 1. Finding a Candidate:
 * The algorithm for first phase that works in O(n) is known as Moore’s Voting Algorithm. Basic idea of the algorithm is
 * if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist
 * till end if it is a majority element.
 * <p>
 * findCandidate(a[], size)
 * 1.  Initialize index and count of majority element
 * maj_index = 0, count = 1
 * 2.  Loop for i = 1 to size – 1
 * (a)If a[maj_index] == a[i]
 * count++
 * (b)Else
 * count--;
 * (c)If count == 0
 * maj_index = i;
 * count = 1
 * 3.  Return a[maj_index]
 * Above algorithm loops through each element and maintains a count of a[maj_index], If next element is same then increments the count, if next element is not same then decrements the count, and if the count reaches 0 then changes the maj_index to the current element and sets count to 1.
 * First Phase algorithm gives us a candidate element. In second phase we need to check if the candidate is really a majority element. Second phase is simple and can be easily done in O(n). We just need to check if count of the candidate element is greater than n/2.
 * <p>
 * Example:
 * A[] = 2, 2, 3, 5, 2, 2, 6
 * Initialize:
 * maj_index = 0, count = 1 –> candidate ‘2?
 * 2, 2, 3, 5, 2, 2, 6
 * <p>
 * Same as a[maj_index] => count = 2
 * 2, 2, 3, 5, 2, 2, 6
 * <p>
 * Different from a[maj_index] => count = 1
 * 2, 2, 3, 5, 2, 2, 6
 * <p>
 * Different from a[maj_index] => count = 0
 * Since count = 0, change candidate for majority element to 5 => maj_index = 3, count = 1
 * 2, 2, 3, 5, 2, 2, 6
 * <p>
 * Different from a[maj_index] => count = 0
 * Since count = 0, change candidate for majority element to 2 => maj_index = 4
 * 2, 2, 3, 5, 2, 2, 6
 * <p>
 * Same as a[maj_index] => count = 2
 * 2, 2, 3, 5, 2, 2, 6
 * <p>
 * Different from a[maj_index] => count = 1
 * <p>
 * Finally candidate for majority element is 2.
 * <p>
 * First step uses Moore’s Voting Algorithm to get a candidate for majority element.
 * <p>
 * 2. Check if the element obtained in step 1 is majority
 * <p>
 * printMajority (a[], size)
 * 1.  Find the candidate for majority
 * 2.  If candidate is majority. i.e., appears more than n/2 times.
 * Print the candidate
 * 3.  Else
 * Print "NONE"
 */
public class MajorityElement {

    public static int majorityElem(int[] ary) {
        // find candidate for majority element. Element occuring more number of times in the arrays
        int majIndex = 0, count = 0;
        for (int i = 1; i < ary.length; i++) {
            if (ary[i] == ary[i - 1]) {
                count++;
            } else {
                count--;
            }
            if (count == 0)
                majIndex++;
        }

        System.out.println("Element occuring most number of times in the array: " + ary[majIndex]);

        // check if this is majority element
        count = 0;
        for (int i : ary) {
            if (i == ary[majIndex])
                count++;
        }

        if (count >= ary.length / 2)
            return ary[majIndex];
        else
            return -1;

    }

    public static void main(String[] args) {
        int[] ary = {1, 3, 3, 1, 1, 1, 2};
        int x = majorityElem(ary);
        if (x != -1)
            System.out.println("Majority element: " + x);
        else
            System.out.println("No majority element in array!!");
    }
}
