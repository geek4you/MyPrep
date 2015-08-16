/**
 * Created by chanumolu on 8/15/15.
 */

/**
 * Sub problem of problem in http://www.geeksforgeeks.org/ugly-numbers/
 *
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 *
 * To check if a number is ugly, divide the number by greatest divisible powers of 2, 3 and 5, if the number becomes 1
 * then it is an ugly number otherwise not.

 For example, let us see how to check for 300 is ugly or not. Greatest divisible power of 2 is 4, after dividing 300 by
 4 we get 75. Greatest divisible power of 3 is 3, after dividing 75 by 3 we get 25. Greatest divisible power of 5 is 25,
 after dividing 25 by 25 we get 1. Since we get 1 finally, 300 is ugly number.
 */
public class CheckIfUglyNumber {

    public static boolean isUgly(int n){

        // divide with the greatest divisible power of 2
        while(n%2 == 0){
            n = n/2;
        }

        System.out.println("After 2's : "+n);

        // divide with greatest divisable power of 3
        while(n%3 == 0){
            n = n/3;
        }

        System.out.println("After 3's : "+n);

        // divide with greatest divisable power of 5
        while(n%5 == 0){
            n = n/5;
        }

        System.out.println("After 5's : "+n);

        if(n==1)
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(5832));
        System.out.println(isUgly(300));
        System.out.println(isUgly(5830));
    }
}
