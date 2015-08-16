/**
 * Created by chanumolu on 8/15/15.
 */

import java.util.List;

/**
 * @link : http://www.geeksforgeeks.org/ugly-numbers/
 */
public class UglyNumbers {

    /**
     * Non - DP method
     */
    public static void nthUgly1(int n) {

        int count = 1;
        int i = 2;
        while (count < n) {
            int y = i;
            System.out.println("======================");
            System.out.println("i= " + i);
            y = afterDiv(y, 2);
            System.out.println("After 2: " + y);
            y = afterDiv(y, 3);
            System.out.println("After 3: " + y);
            y = afterDiv(y, 5);
            System.out.println("After 5: " + y);
            if (y == 1) {
                count++;
                System.out.println(count + "th ugly number: " + i);
            }

            i++;
        }

        System.out.println(n + "th ugly number : " + (i - 1));

    }

    public static int afterDiv(int n, int x) {
        while (n % x == 0)
            n = n / x;

        return n;
    }


    /**
     * Dynamic programming
     * <p>
     * Here is a time efficient solution with O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
     * because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:
     * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     * (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     * <p>
     * We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5. Then we use
     * similar merge method as merge sort, to get every ugly number from the three subsequence. Every step we choose the
     * smallest one, and move one step after.
     * <p>
     * <p>
     * Algorithm:
     * <p>
     * 1 Declare an array for ugly numbers:  ugly[150]
     * 2 Initialize first ugly no:  ugly[0] = 1
     * 3 Initialize three array index variables i2, i3, i5 to point to
     * 1st element of the ugly array:
     * i2 = i3 = i5 =0;
     * 4 Initialize 3 choices for the next ugly no:
     * next_mulitple_of_2 = ugly[i2]*2;
     * next_mulitple_of_3 = ugly[i3]*3
     * next_mulitple_of_5 = ugly[i5]*5;
     * 5 Now go in a loop to fill all ugly numbers till 150:
     * For (i = 1; i < 150; i++ )
     * {
     * next_ugly_no  = Min(next_mulitple_of_2,
     * next_mulitple_of_3,
     * next_mulitple_of_5);
     * if  (next_ugly_no  == next_mulitple_of_2)
     * {
     * i2 = i2 + 1;
     * next_mulitple_of_2 = ugly[i2]*2;
     * }
     * if  (next_ugly_no  == next_mulitple_of_3)
     * {
     * i3 = i3 + 1;
     * next_mulitple_of_3 = ugly[i3]*3;
     * }
     * if  (next_ugly_no  == next_mulitple_of_5)
     * {
     * i5 = i5 + 1;
     * next_mulitple_of_5 = ugly[i5]*5;
     * }
     * ugly[i] =  next_ugly_no
     * }
     * <p>
     * 6.return next_ugly_no
     * <p>
     * <p>
     * Example:
     * Let us see how it works
     * <p>
     * initialize
     * ugly[] =  | 1 |
     * i2 =  i3 = i5 = 0;
     * <p>
     * First iteration
     * ugly[1] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
     * = Min(2, 3, 5)
     * = 2
     * ugly[] =  | 1 | 2 |
     * i2 = 1,  i3 = i5 = 0  (i2 got incremented )
     * <p>
     * Second iteration
     * ugly[2] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
     * = Min(4, 3, 5)
     * = 3
     * ugly[] =  | 1 | 2 | 3 |
     * i2 = 1,  i3 =  1, i5 = 0  (i3 got incremented )
     * <p>
     * Third iteration
     * ugly[3] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
     * = Min(4, 6, 5)
     * = 4
     * ugly[] =  | 1 | 2 | 3 |  4 |
     * i2 = 2,  i3 =  1, i5 = 0  (i2 got incremented )
     * <p>
     * Fourth iteration
     * ugly[4] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
     * = Min(6, 6, 5)
     * = 5
     * ugly[] =  | 1 | 2 | 3 |  4 | 5 |
     * i2 = 2,  i3 =  1, i5 = 1  (i5 got incremented )
     * <p>
     * Fifth iteration
     * ugly[4] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
     * = Min(6, 6, 10)
     * = 6
     * ugly[] =  | 1 | 2 | 3 |  4 | 5 | 6 |
     * i2 = 3,  i3 =  2, i5 = 1  (i2 and i3 got incremented )
     * <p>
     * Will continue same way till I < 150
     */
    public static void nthUgly(int n) {

        int[] ugly = new int[n];

        int i = 0, i2 = 0, i3 = 0, i5 = 0;

        ugly[i] = 1;
        i++;
        while (i < n) {

            int nextUgly = min(nextMultipleOf2(ugly[i2]), nextMultipleOf3(ugly[i3]), nextMultipleOf5(ugly[i5]));
            ugly[i] = nextUgly;
            i++;

            if(nextUgly == nextMultipleOf2(ugly[i2]))
                i2++;

            if(nextUgly == nextMultipleOf3(ugly[i3]))
                i3++;

            if(nextUgly == nextMultipleOf5(ugly[i5]))
                i5++;

        }

        System.out.println(n+"th ugly number : "+ ugly[n-1]+" !!");
    }

    public static int nextMultipleOf2(int x) {
        return 2 * x;
    }

    public static int nextMultipleOf3(int x) {
        return 3 * x;
    }

    public static int nextMultipleOf5(int x) {
        return 5 * x;
    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else if (b < c)
            return b;
        else
            return c;

    }

    public static void main(String[] args) {
        int n = 3;
        nthUgly(150);
    }
}
