/**
 * Created by chanumolu on 8/12/15.
 */

/**
 * Given a collection of sorted (by start point) non-overlapping intervals and a point, find the interval into which this point falls.

 Solution: use binary search. O(logn) time, O(1) space

 while (beg <= end) {
 int mid = (beg + end)/2;
 if (intervals[mid].start <= point && intervals[mid].end >= point) {

 cout<<"["<<intervals[mid].start<<","<<intervals[mid].end<<"]"<<endl;
 return;
 } else if (intervals[mid].start <= point) {
 beg = mid + 1;
 } else {
 end = mid - 1;
 }
 }
 */
public class IntervalIntoWhichPointFallas {
}
