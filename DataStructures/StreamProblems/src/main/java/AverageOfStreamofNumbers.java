/**
 * Created by chanumolu on 8/9/15.
 */

/**
 *  @link : http://www.geeksforgeeks.org/average-of-a-stream-of-numbers/
 *
 * Two ways for avg
 * 1) sum/n
 * 2) (prev_avg*n + x) / (n+1)
 */
public class AverageOfStreamofNumbers {

    public static void streamAvg (int[] stream ){

        int sum = 0;
        int n =0;
        for(int i=0 ; i<stream.length ; i++){
            System.out.println("Reading "+stream[i]+" from the stream !!");
            n++;
            sum = sum + stream[i];
            int avg = sum / n;

            System.out.println("Avg of "+n + "numbers read from the stream is "+avg);
        }
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60};
        streamAvg(arr);
    }
}
