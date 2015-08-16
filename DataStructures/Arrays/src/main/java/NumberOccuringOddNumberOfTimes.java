/**
 * Created by chanumolu on 6/15/15.
 */

/**
 * Find the Number Occurring Odd Number of Times
 * Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number
 * of times. Find the number in O(n) time & constant space.
 * <p>
 * Example:
 * I/P = [1, 2, 3, 2, 3, 1, 3]
 * O/P = 3
 * <p>
 * Algorithm:
 * Do bitwise XOR of all the elements. Finally we get the number which has odd occurrences.
 */
public class NumberOccuringOddNumberOfTimes {

    public static void occuringOddNumberOfTimes(int[] ary) {
        int num = 0;
        for (int i : ary) {
            num = num ^ i;
        }

        System.out.println("Number occuring odd number of times: " + num);
    }

    public static void main(String[] args) {
        int[] ary = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2, 5, 2};
        occuringOddNumberOfTimes(ary);
    }
}
