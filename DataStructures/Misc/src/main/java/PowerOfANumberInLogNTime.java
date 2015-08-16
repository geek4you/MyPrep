/**
 * Created by chanumolu on 7/30/15.
 */

public class PowerOfANumberInLogNTime {


    static int powerNTime(int x, int y) {
        if (y == 0) {
            return 1;
        } else if (y == 1) {
            return x;
        } else {
            if (y % 2 == 0) {
                return powerLogNTime(x, y / 2) * powerLogNTime(x, y / 2);
            } else {
                return x * powerLogNTime(x, y / 2) * powerLogNTime(x, y / 2);
            }
        }
    }

    //Above function can be optimized to O(logn) by calculating power(x, y/2) only once and storing it
    // log n time
    // x power y
    public static int powerLogNTime(int x, int y) {
        if (y == 0) {
            return 1;
        } else if (y == 1) {
            return x;
        } else {
            int temp = powerLogNTime(x, y / 2);
            if (y % 2 == 0) {
                return temp * temp;
            } else {
                return x * temp * temp;
            }
        }
    }

    //Let us extend the pow function to work for negative y and float x.
    static float powerLogNAllCases(int x, int y){
        float temp;
        if( y == 0)
            return 1;
        temp = powerLogNAllCases(x, y/2);
        if (y%2 == 0)
            return temp*temp;
        else
        {
            if(y > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }
    }

    public static void main(String[] args) {
        System.out.println(powerLogNTime(2, 3));
    }
}
