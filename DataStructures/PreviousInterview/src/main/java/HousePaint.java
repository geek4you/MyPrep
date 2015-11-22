/**
 * Created by chanumolu on 11/5/15.
 */

import java.util.Arrays;

/**
 * Problem Statement (From Topcoder)
 * <p>
 * The people of RGB Street have decided to paint each of their houses red, green, or blue. They've also decided that no
 * two neighboring houses will be painted the same color. The neighbors of house i are houses i-1 and i+1. The first and
 * last houses are not neighbors.
 * <p>
 * You will be given a String[] houses, where the ith element corresponds to house i. Each element of houses will be
 * formatted as "R G B" (quotes for clarity only), where R, G and B are the costs of painting the corresponding house red,
 * green, and blue, respectively. Return the minimal total cost required to perform the work.
 * <p>
 * <p>
 * Definition
 * <p>
 * Class:	RGBStreet
 * Method:	estimateCost
 * Parameters:	String[]
 * Returns:	int
 * Method signature:	int estimateCost(String[] houses)
 * (be sure your method is public)
 * <p>
 * <p>
 * Constraints
 * -	houses will contain between 1 and 20 elements, inclusive.
 * -	Each element of houses will be in the format "R G B" (quotes for clarity only), where R, G and B are integers with
 * no leading zeroes.
 * -	In each element of houses, the values R, G and B will be between 1 and 1000, inclusive.
 * <p>
 * Examples
 * 0)
 * <p>
 * {"1 100 100", "100 1 100", "100 100 1"}
 * Returns: 3
 * "RGB" is the best choice, and the total cost of the work is equal to 3.
 * 1)
 * <p>
 * {"1 100 100", "100 100 100", "1 100 100"}
 * Returns: 102
 * The minimum possible cost is 102, and there are two solutions that result in that cost: "RGR" and "RBR".
 * 2)
 * <p>
 * {"26 40 83", "49 60 57", "13 89 99"}
 * Returns: 96
 * 3)
 * <p>
 * {"30 19 5", "64 77 64", "15 19 97", "4 71 57", "90 86 84", "93 32 91"}
 * Returns: 208
 * 4)
 * <p>
 * {"71 39 44", "32 83 55", "51 37 63", "89 29 100",
 * "83 58 11", "65 13 15", "47 25 29", "60 66 19"}
 * Returns: 253
 */
public class HousePaint {

    public static int estimateCosts(String[] houses) {
        int n = houses.length;

        // accumulated costs array
        int[][] accuCosts = new int[n][3];

        // get the fitst house costs
        for (int i = 0; i < 3; i++) {
            accuCosts[0][i] = Integer.parseInt(houses[0].split(" ")[i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                accuCosts[i][j] = Integer.MAX_VALUE;
                int cost = Integer.parseInt(houses[i].split(" ")[j]);
                for (int k = 0; k < 3; k++) {
                    if (k == j)
                        continue;

                    accuCosts[i][j] = Math.min(accuCosts[i][j], accuCosts[i - 1][k] + cost);
                }
            }
        }

        System.out.println("Accumulated Costs: ");
        for(int i=0;i<n;i++)
        System.out.println(Arrays.toString(accuCosts[i]));
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, accuCosts[n - 1][i]);
        }

        return res;
    }

    public static void main(String[] args) {

        //3
        String[] houses1 = new String[]{"1 100 100", "1 100 1", "100 100 1000"};
        System.out.println(estimateCosts(houses1));

        //196
        String[] houses2 = new String[]{"26 40 83", "49 60 57", "13 89 99"};
        System.out.println(estimateCosts(houses2));

        //208
        String[] houses3 = new String[]{"30 19 5", "64 77 64", "15 19 97", "4 71 57", "90 86 84", "93 32 91"};
        System.out.println(estimateCosts(houses3));

        //253
        String[] houses4 = new String[]{"71 39 44", "32 83 55", "51 37 63", "89 29 100", "83 58 11", "65 13 15",
                "47 25 29", "60 66 19"};
        System.out.println(estimateCosts(houses4));
    }
}
