/**
 * Created by chanumolu on 6/17/15.
 */

/**
 * @link: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * <p>
 * 2 procedures : 1) O(n)
 * 2) O(logn)
 * Median of two sorted arrays
 * Question: There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array
 * obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n))
 * <p>
 * For getting the median of input array { 12, 11, 15, 10, 20 }, first sort the array. We get { 10, 11, 12, 15, 20 }
 * after sorting. Median is the middle element of the sorted array which is 12.
 * <p>
 * Use merge procedure of merge sort. Keep track of count while comparing elements of two arrays.
 * If count becomes n(For 2n elements), we have reached the median. Take the average of the elements at indexes n-1
 * and n in the merged array.
 */
public class MedianOfTwoArrays {

    /**
     * This function returns median of ar1[] and ar2[].
     * Assumptions in this function:
     * Both ar1[] and ar2[] are sorted arrays
     * Both have n elements
     */
    public static int median(int[] ary1, int[] ary2) {
        int i = 0, j = 0, count = 0;
        int m1 = -1, m2 = -1;
        int n = ary1.length;
        /* Since there are 2n elements, median will be average
        of elements at index n-1 and n in the array obtained after
        merging ar1 and ar2 */
        for (count = 0; count <= n; count++) {

            /*Below is to handle case where all elements of ar1[] are
          smaller than smallest(or first) element of ar2[]*/
            if (i == n) {
                m1 = m2;
                m2 = ary2[0];
                break;
            }

            /*Below is to handle case where all elements of ar2[] are
          smaller than smallest(or first) element of ar1[]*/
            if (j == n) {
                m1 = m2;
                m2 = ary1[0];
                break;
            }

            if (ary1[i] < ary2[j]) {
                m1 = m2;  /* Store the prev median */
                m2 = ary1[i];
                i++;
            } else {
                m1 = m2;  /* Store the prev median */
                m2 = ary2[j];
                j++;
            }
        }

        return (m1 + m2) / 2;
    }

    public static int median2(int[] arry1, int[] arry2) {

        if (arry1.length != arry2.length)
            throw new RuntimeException("Invalid Input!!");

        if (arry1.length <= 0)
            return -1;

        if (arry1.length == 1)
            return (arry1[0] + arry2[0]) / 2;

        return median2Util(arry1, 0, arry1.length - 1, arry2, 0, arry2.length - 1);
    }

    public static int medianOfSingleArray(int arr[], int low, int high) {
        int n = (high - low)+1;
        if (n % 2 == 0)
            return (arr[n / 2] + arr[n / 2 - 1]) / 2;
        else
            return arr[n / 2];
    }

    public static int median2Util(int[] arry1, int low1, int high1, int[] arry2, int low2, int high2) {
        if (high1 - low1 + 1 == 2) {
            return ((Math.max(arry1[low1], arry2[low2]) + Math.min(arry1[high1], arry2[high2])) / 2);
        }

        // calculate median of two arrays
        int med1 = medianOfSingleArray(arry1, low1, high1);
        int med2 = medianOfSingleArray(arry2, low2, high2);

        if(med1==med2)
            return med1;

        else if(med1>med2){
            // should be in lower half of arry1 and higher half of arry2

                return median2Util(arry1,low1,(high1-low1)/2,arry2,(high2-low2)/2+1,high2);
        }else{
            return median2Util(arry1,(high1-low1)/2, high2,arry2,low2,(high2-low2)/2);
        }
    }

    public static void main(String[] args) {
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};

        System.out.println("Median: " + median2(ar1, ar2));
    }
}
