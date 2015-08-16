/**
 * Created by chanumolu on 8/4/15.
 */


/**
 * Write a function that returns the overlapping interval
 */
public class GetOverlappingInterval {

    public static Interval overlapSearch(ITNode root, Interval i) {

        // base case
        if (null == root)
            return null;

        // If given interval overlaps with root
        if (doOVerlap(root.interval, i)) {
            return root.interval;
        }

        // If left child of root is present and max of left child is
        // greater than or equal to given interval, then i may
        // overlap with an interval is left subtree
        if (root.left != null && root.left.max >= i.start)
            return overlapSearch(root.left, i);

        // Else interval can only overlap with right subtree
        return overlapSearch(root.right, i);

    }

    // A utility function to check if given two intervals overlap
    static boolean doOVerlap(Interval i1, Interval i2) {
        if (i1.start <= i2.end && i2.start <= i1.end)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(15, 20), new Interval(10, 30), new Interval(17, 19), new Interval(5, 20), new Interval(12, 15
        ), new Interval(30, 40)};
        ITNode root = null;

        for (int i = 0; i < intervals.length; i++)
            root = IntervalTree.insert(root, intervals[i]);

        System.out.println("Inorder traversal of constructed Interval Tree is\n");
        IntervalTree.inorder(root);

        Interval x = new Interval(6,7);
        System.out.println("\nSearching for interval [" + x.start + "," + x.end + "]");
        Interval res = overlapSearch(root, x);

        if(null == res){
            System.out.println("No intersection!! ");
        }else{
            System.out.println("Overlaps with [ "+res.start+","+res.end+" ]");
        }
    }
}
