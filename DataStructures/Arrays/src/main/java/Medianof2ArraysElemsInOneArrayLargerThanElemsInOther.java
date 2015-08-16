/**
 * Created by chanumolu on 6/28/15.
 */

/**
 * @link: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 *
 * last method in this page.
 */
public class Medianof2ArraysElemsInOneArrayLargerThanElemsInOther {

    int getMedian(int ar1[], int ar2[], int n)
    {
        // If all elements of array 1 are smaller then
        // median is average of last element of ar1 and
        // first element of ar2
        if (ar1[n-1] < ar2[0])
            return (ar1[n-1]+ar2[0])/2;

        // If all elements of array 1 are smaller then
        // median is average of first element of ar1 and
        // last element of ar2
        else // (ar2[n-1] < ar1[0])
            return (ar2[n-1]+ar1[0])/2;

    }
}
