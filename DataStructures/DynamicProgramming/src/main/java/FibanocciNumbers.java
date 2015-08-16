/**
 * Created by chanumolu on 8/15/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @link : http://www.geeksforgeeks.org/dynamic-programming-set-1/
 */
public class FibanocciNumbers {

    /**
     * Using Memorization (Top-Down)
     *
     * @return
     */
    public static int fib1(int n, List<Integer> list) {

        if (list.get(n) == null) {
            if (n <= 1) {
                list.add(n, 1);
            } else {
                list.add(n, fib1(n - 1, list) + fib1(n - 2, list));
            }
            System.out.println("Fibanocci number " + n + " is : " + list.get(n));
            return list.get(n);
        }

        return list.get(n);

    }

    /**
     * Tabulation method ( Bottom-Up)
     *
     * @param n
     * @return
     */
    public static void fib2(int n) {

        List<Integer> fib = new ArrayList<Integer>(n+1);
        fib.add(0,1);
        fib.add(0,1);

        for(int i =2; i<=n ;i++){
            int fibanocci = fib.get(i-1)+ fib.get(i-2);
            fib.add(i,fibanocci);
        }

        for(int i =0 ; i<n+1 ;i++)
            System.out.println("Fib number "+i+" is "+ fib.get(i));

    }

    public static void main(String[] args) {
        int n = 40;
        List<Integer> l = new ArrayList<Integer>();
        System.out.println("=================Memorization Method (Top-Down) ================== ");
        for (int i = 0; i < n + 1; i++) {
            l.add(null);
        }
        System.out.println(fib1(n, l));


        System.out.println("=================Tabular Method (Bottom-Up) ================== ");
        fib2(40);
    }
}
