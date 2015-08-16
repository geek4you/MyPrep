/**
 * Created by chanumolu on 8/12/15.
 */

/**
 * Given two arrays of intervals (non-overlapping, sorted by start point), output their intersection.

 Solution: scan the two intervals at the same time, get the maximum of current two intervals' start points and minimum
 of their end points. Output the new interval if maxstart <= maxend. Increase the iterator whose end point is smaller.
 */
public class IntersectionOfTwoArraysOfIntervals {
}
