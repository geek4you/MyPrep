/**
 * Created by chanumolu on 6/19/15.
 */

/**
 * Same question as max prod sub sequence but should contain atleast 2 elems
 */
public class MaxProdSubSequenceAtleast2Elems {

    private static int maxProduct(int[] ary) {
        int maxNow = ary[0] * ary[1];
        int minNow = ary[0] * ary[1];
        int max_value = maxNow;

        for (int i = 1; i < ary.length; i++) {
            int maxNow_prev = maxNow;
            int minNow_prev = minNow;

            maxNow = max(ary[i] * ary[i-1] , ary[i] * maxNow_prev, ary[i] * minNow_prev);
            minNow = min(ary[i] * ary[i-1] , ary[i] * maxNow_prev, ary[i] * minNow_prev);
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
