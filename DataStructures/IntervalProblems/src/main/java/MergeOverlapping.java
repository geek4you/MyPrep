import java.util.*;

/**
 * Created by chanumolu on 7/30/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/merging-intervals/
 */
public class MergeOverlapping {

    // The main function that takes a set of intervals, merges
    // overlapping intervals and prints the result
    public static void mergeIntervals(List<Interval> intervals) {

        // Test if the given set has at least one interval
        if (intervals.size() <= 0)
            throw new RuntimeException("Invalid input");

        // Create an empty stack of intervals
        Deque<Interval> stack = new ArrayDeque<Interval>();

        // sort
        Collections.sort(intervals, new CustomComparator());

        System.out.println("Sorted list");
        for (Interval i : intervals) {
            System.out.print(i + ",");
        }

        // push the first interval to stack
        stack.push(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            // get top
            Interval top = stack.peek();

            // check with next interval
            Interval current = intervals.get(i);
            // merge condition
            if (current.start < top.end) {
                // TODO: imp condition
                int end = Math.max(current.start,top.end);
                // create new interval
                Interval interval = new Interval(top.start, end);
                // pop the top of stack
                stack.pop();
                // push into stack
                stack.push(interval);
            } else {
                // if current interval is not overlapping with stack top,
                // push it to the stack
                stack.push(current);
            }

        }

        // print stack
        System.out.println("Merged intervals: ");
        for (Interval in : stack) {
            System.out.print(in + ",");
        }

    }

    public static void main(String[] args) {
        TestCase1();
        //TestCase2();
        //TestCase3();
    }

    static void TestCase1() {
        // Create a set of intervals
        List<Interval> intvls = new ArrayList<Interval>();
        intvls.add(new Interval(6, 8));
        intvls.add(new Interval(1, 9));
        intvls.add(new Interval(2, 4));
        intvls.add(new Interval(4, 7));

        // Merge overlapping inervals and print result
        mergeIntervals(intvls);
    }

    static void TestCase2() {
        // Create a set of intervals
        // Create a set of intervals
        List<Interval> intvls = new ArrayList<Interval>();
        intvls.add(new Interval(6, 8));
        intvls.add(new Interval(1, 3));
        intvls.add(new Interval(2, 4));
        intvls.add(new Interval(4, 7));

        // Merge overlapping inervals and print result
        mergeIntervals(intvls);
    }

    static void TestCase3() {
        // Create a set of intervals
        List<Interval> intvls = new ArrayList<Interval>();
        intvls.add(new Interval(1, 3));
        intvls.add(new Interval(7, 9));
        intvls.add(new Interval(4, 6));
        intvls.add(new Interval(10, 13));

        // Merge overlapping inervals and print result
        mergeIntervals(intvls);
    }

}

class CustomComparator implements Comparator<Interval> {
    public int compare(Interval o1, Interval o2) {
        if (o1.start > o2.start)
            return 1;
        else {
            return -1;
        }
    }
}
