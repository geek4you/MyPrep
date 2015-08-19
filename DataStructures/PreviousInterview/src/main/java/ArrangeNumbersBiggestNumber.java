/**
 * Created by chanumolu on 8/18/15.
 */

import java.util.*;

/**
 * @link : http://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 * <p>
 * Given an array of numbers, arrange them in a way that yields the largest value. For example, if the given numbers are
 * {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. And if the given numbers are
 * {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 * <p>
 * A simple solution that comes to our mind is to sort all numbers in descending order, but simply sorting doesn’t work.
 * For example, 548 is greater than 60, but in output 60 comes before 548. As a second example, 98 is greater than 9, but
 * 9 comes before 98 in output.
 * <p>
 * So how do we go about it? The idea is to use any comparison based sorting algorithm. In the used sorting algorithm,
 * instead of using the default comparison, write a comparison function myCompare() and use it to sort numbers. Given two
 * numbers X and Y, how should myCompare() decide which number to put first – we compare two numbers XY (Y appended at the
 * end of X) and YX (X appended at the end of Y). If XY is larger, then X should come before Y in output, else Y should
 * come before. For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542. Since 60542 is
 * greater than 54260, we put Y first.
 */
public class ArrangeNumbersBiggestNumber {

    public static int concatenateNumbers(Integer[] arr) {
        Arrays.sort(arr,new MyComparator());
        StringBuffer st = new StringBuffer();
        for (int i : arr)
            st = st.append(i);

        return Integer.parseInt(st.toString().trim());

    }

    public static void main(String[] args) {
        Integer[] arr = {54, 546, 548, 60};
        System.out.println(concatenateNumbers(arr));
    }

}

class MyComparator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        String str1 = o1 + "" + o2;
        String str2 = o1 + "" + o2;
        if ((str1).compareTo(str2) > 0)
            return 1;
        else
            return -1;
    }
}
