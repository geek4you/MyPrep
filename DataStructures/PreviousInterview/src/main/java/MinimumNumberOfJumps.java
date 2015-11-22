/**
 * Created by chanumolu on 11/7/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * There is a row of seats. Assume that it contains N seats adjacent to each other.
 * There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are
 * scattered.
 * <p>
 * An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
 * <p>
 * Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between
 * them in such a way that the total number of hops or jumps to move them should be minimum.
 * <p>
 * Example
 * <p>
 * Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) -
 * <p>
 * . . . . x . . x x . . . x . .
 * Now to make them sit together one of approaches is - . . . . . . x x x x . . . . .
 * <p>
 * Following are the steps to achieve this - 1 - Move the person sitting at 4th index to 6th index -
 * Number of jumps by him = (6 - 4) = 2
 * <p>
 * 2 - Bring the person sitting at 12th index to 9th index - Number of jumps by him = (12 - 9) = 3
 * <p>
 * So now the total number of jumps made = ( 2 + 3 ) % MOD = 5 which is the minimum possible jumps to make them seat together.
 * <p>
 * There are also other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.
 * <p>
 * For example bring them all towards the starting of the row i.e. start placing them from index 0. In that case the total
 * number of jumps will be ( 4 + 6 + 6 + 9 )%MOD = 25 which is very costly and not an optimized way to do this movement
 */
public class MinimumNumberOfJumps {


    /**
     * Greedy Solution:
     * https://leetcode.com/discuss/61447/minimum-number-of-jumps
     * <p>
     * Actually we can use greedy algorithm, the idea is simple, every time we consider the people groups from left and
     * right sides, pick the group that has less people and move towards center, for example we have the following input:
     * <p>
     * . . X X . . . X X . . X X . . X X X . . .
     * <p>
     * there are two people in the far left group and three people in the far right group, so let's merge the people
     * group from left, and we get the following:
     * <p>
     * . . . . . X X X X . . X X . . X X X . . .
     * <p>
     * now merge the far right group and we get:
     * <p>
     * . . . . . X X X X . . X X X X X . . . . .
     * <p>
     * finally we get:
     * <p>
     * . . . . . . . X X X X X X X X X . . . . .
     * <p>
     * Time complexity is O(n + k), where k is the number of group of people initially.
     */
    public int minMoves(char[] seats) {
        // step 1. add all groups to deque
        Deque<int[]> dq = new ArrayDeque<int[]>();

        int i = 0, j = 0, n = seats.length;
        while (j < n) {

            // skip "."
            if (j < n && seats[j] == '.')
                j++;
            if (j == n) break;

            // go through 'X'
            for (i = j; j < n && seats[j] == 'X'; j++) {
            }

            // add group to deque
            dq.addLast(new int[]{i, j - 1});
        }

        // step 2. merge groups from both ends
        int count = 0;
        while (dq.size() > 1) {
            int[] left = dq.peekFirst();
            int[] right = dq.peekLast();
            int lenLeft = left[1] - left[0] + 1;
            int lenRight = right[1] - right[0] + 1;

            if (lenLeft <= lenRight) {
                // merge left two groups
                left = dq.pollFirst();
                count += lenLeft * (dq.peekFirst()[0] - left[1] - 1);
                dq.peekFirst()[0] -= lenLeft;
            } else {
                // merge right two groups
                right = dq.pollLast();
                count += lenRight * (right[0] - dq.peekLast()[1] - 1);
                dq.peekLast()[1] += lenRight;
            }
        }
        return count;
    }


    /**
     * Brute Force:
     * <p>
     * First let's solve this problem using brute force, let's group all the k people together and form a window size of k.
     * Move the window and compare to the original positions, then count the hops and get minimum value.
     * Time complexity is O((n - k) * n), we can optimize to O((n - k) * k), n is the number of seats, and k is the
     * number of people.
     *
     * @param seats
     * @return
     */
    public int minMovesBruteForce(char[] seats) {
        int n = seats.length;

        // step 1. count people
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 'X') {
                k++;
            }
        }

        // step 2. move the window of size k and count the hops
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n - k; j++) {
            int hops = 0, p = j;

            for (int i = 0; i < n; i++) {
                if (seats[i] == 'X') {
                    hops += Math.abs(i - p++);
                }
            }

            min = Math.min(min, hops);
        }

        return min;
    }
}
