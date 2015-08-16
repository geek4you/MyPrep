/**
 * Created by chanumolu on 8/5/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/given-n-appointments-find-conflicting-appointments/
 * <p>
 * Given n appointments, find all conflicting appointments
 * <p>
 * Input: appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}}
 * Output: Following are conflicting intervals
 * [3,7] Conflicts with [1,5]
 * [2,6] Conflicts with [1,5]
 * [5,6] Conflicts with [3,7]
 * [4,100] Conflicts with [1,5]
 * <p>
 * An appointment is conflicting, if it conflicts with any of the previous appointments in array.
 * <p>
 * 1) Create an Interval Tree, initially with the first appointment.
 * 2) Do following for all other appointments starting from the second one.
 * a) Check if the current appointment conflicts with any of the existing
 * appointments in Interval Tree.  If conflicts, then print the current
 * appointment.  This step can be done O(Logn) time.
 * b) Insert the current appointment in Interval Tree. This step also can
 * be done O(Logn) time.
 *
 * Note that the above implementation uses simple Binary Search Tree insert operations.
 * Therefore, time complexity of the above implementation is more than O(nLogn). We can use Red-Black Tree or AVL Tree
 * balancing techniques to make the above implementation O(nLogn).
 */
public class ConflictingAppointments {

    public static void conflicts(Interval[] intervals) {
        if (intervals.length < 2)
            return;

        // construct a interval tree with first entry
        Interval first = intervals[0];

        ITNode root = new ITNode(first);

        for (int i = 1; i < intervals.length; i++) {
            printOverlapings(root, intervals[i]);
            insert(root,intervals[i]);
        }
    }

    public static void printOverlapings(ITNode root, Interval interval) {
        if (null == root)
            return;

        // check if root is overlapping
        if (isOverlaping(root.interval, interval)) {
            System.out.println("[" + root.interval.start + " , "
                    + root.interval.end + "] is conflicting with [" + interval.start + " , " + interval.end + "]");
        }

        // check left and right subtrees
        if (null != root.left && root.left.max > interval.start) {
            printOverlapings(root.left, interval);
        } else {
            printOverlapings(root.right, interval);
        }
    }

    public static ITNode insert(ITNode root, Interval interval) {
        if (null == root)
            return new ITNode(interval);

        if (root.max < interval.end) {
            root.max = interval.end;
        }

        if (root.interval.start <= interval.start) {
            root.left = insert(root.left, interval);
        } else {
            root.right = insert(root.right, interval);
        }

        return root;
    }

    public static boolean isOverlaping(Interval i1, Interval i2) {
        return i1.start < i2.end && i2.start < i1.end;
    }

    public static void main(String[] args) {

        Interval appt[] = {new Interval(1, 5), new Interval(3, 7), new Interval(2, 6),
                new Interval(10, 15), new Interval(5, 6), new Interval(4, 100)};

        conflicts(appt);


    }

}
