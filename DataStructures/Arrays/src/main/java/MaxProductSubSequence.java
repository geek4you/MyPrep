/**
 * Created by chanumolu on 6/18/15.
 */

/**
 * Given an array of REAL numbers that does not contain 0, find the consecutive elements that yield max product.
 * The algorithm should run in linear time
 * <p>
 * The algorithm is indeed O(n). When iterating the array, use a variable to store the max value found so far,
 * a variable to store the max value of subarray that ends at a[i], and another variable to store minimum value that
 * ends at a[i] to treat negative values.
 */
public class MaxProductSubSequence {

    private static int maxProduct(int[] ary) {
        int maxNow = ary[0];
        int minNow = ary[0];
        int max_value = maxNow;

        for (int i = 1; i < ary.length; i++) {
            int maxNow_prev = maxNow;
            int minNow_prev = minNow;

            maxNow = max(ary[i], ary[i] * maxNow_prev, ary[i] * minNow_prev);
            minNow = min(ary[i], ary[i] * maxNow_prev, ary[i] * minNow_prev);
            max_value = Math.max(maxNow,max_value);
        }

        return max_value;
    }

    private static int max(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > c)
            return b;
        return c;
    }

    private static int min(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else if (b < c)
            return b;
        return c;
    }

    public static void main(String[] args) {
        int[] ary = {-3, -4, 4, -1, -2, 1, 5, -3};
        System.out.println(maxProduct(ary));
    }

}
