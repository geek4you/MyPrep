/**
 * Created by chanumolu on 8/12/15.
 */

/**
 * giving lots of intervals [ai, bi], find a interval which intersect with the most number of intervals
 * Can we do this in O(nlogn) or better?
 * <p>
 * sol:
 * 1) find intersection count for 1st interval. O(n)
 * 1) construct Interval tree with 1st element.
 * 2) for rest of intervals , while inserting into tree search for overlaps and return count
 */
public class IntervalWithMostNumberOfIntersections {

    public static void maxIntersectionInverval(Interval[] intervals) {
        if (intervals.length < 2)
            return;

        int[] counts = new int[intervals.length];

        // intersection count for 1st interval
        Interval first = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (doOverlap(first,intervals[i]))
                counts[0]++;
        }

        // construct a interval tree with first entry
        ITNode root = new ITNode(first);

        for (int i = 1; i < intervals.length; i++) {
            printOverlapings(root, intervals[i],counts,i);
            insert(root, intervals[i]);
        }

        // now counts[] has all the counts
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i<counts.length;i++){
            if(max<counts[i]){
                max = counts[i];
                index = i;
            }
        }

        System.out.println("Interval "+intervals[index]+" has most number of intersections!! Count: "+max);


    }

    public static void printOverlapings(ITNode root, Interval interval,int[] counts,int index) {
        if (null == root)
            return;

        // check if root is overlapping
        if (isOverlaping(root.interval, interval)) {
            counts[index]++;
            System.out.println("[" + root.interval.start + " , "
                    + root.interval.end + "] is conflicting with [" + interval.start + " , " + interval.end + "]");
        }

        // check left and right subtrees
        if (null != root.left && root.left.max > interval.start) {
            printOverlapings(root.left, interval,counts,index);
        } else {
            printOverlapings(root.right, interval,counts,index);
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

    public static boolean doOverlap(Interval i1, Interval i2) {
        if (i1.start < i2.end && i2.start < i1.end)
            return true;
        return false;
    }

    public static boolean isOverlaping(Interval i1, Interval i2) {
        return i1.start < i2.end && i2.start < i1.end;
    }

    public static void main(String[] args) {

        Interval appt[] = {new Interval(1, 5), new Interval(3, 7), new Interval(2, 6),
                new Interval(10, 15), new Interval(5, 6), new Interval(4, 100)};

        maxIntersectionInverval(appt);


    }
}
