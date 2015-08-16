/**
 * Created by chanumolu on 7/30/15.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, check whether each interval intersect with rest intervals.

 use a pair to store the interval index and the interval. Sort the pair elements by the intervals' start points.
 Scan the pair, check whether current interval intersect with the up to now largest right point. Update up to now
 largest right point if necessary. O(nlogn) time, O(n) space
 */
public class IntersectionIntervals {

    public static boolean allIntersect(List<Interval> intervals){

        if(intervals.size()<1){
            throw new RuntimeException("");
        }

        // sort the invtervals
        Collections.sort(intervals,new CustomComparator());

        // now check the end with the largest end till now.

        int maxEnd = Integer.MIN_VALUE;

        for(Interval in : intervals){
            if(in.start<maxEnd){
                maxEnd = Math.max(in.end,maxEnd);
            }else{
                return false;
            }
        }

        return true;

    }
    public static void main(String[] args) {
        // Create a set of intervals
        List<Interval> intvls = new ArrayList<Interval>();
        intvls.add(new Interval(1, 3));
        intvls.add(new Interval(2, 6));
        intvls.add(new Interval(8, 10));
        intvls.add(new Interval(15, 18));

        System.out.println(allIntersect(intvls));
        TestCase3();
    }

    static void TestCase3() {
        // Create a set of intervals
        List<Interval> intvls = new ArrayList<Interval>();
        intvls.add(new Interval(1, 3));
        intvls.add(new Interval(7, 9));
        intvls.add(new Interval(4, 6));
        intvls.add(new Interval(10, 13));

        // Merge overlapping inervals and print result
        System.out.println(allIntersect(intvls));;
    }

}


