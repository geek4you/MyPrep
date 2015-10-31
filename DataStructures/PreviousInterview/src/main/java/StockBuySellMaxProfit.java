/**
 * Created by chanumolu on 10/28/15.
 */

/**
 * Ooyala Interview
 */

/**
 * Stock Buy Sell to Maximize Profit
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling
 * in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by
 * buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted in
 * decreasing order, then profit cannot be earned at all.
 * <p>
 * If we are allowed to buy and sell only once, then we can use following algorithm. Maximum difference between two elements.
 * Here we are allowed to buy and sell multiple times. Following is algorithm for this problem.
 * <p>
 * 1. Find the local minima and store it as starting index. If not exists, return.
 * 2. Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.
 * 3. Update the solution (Increment count of buy sell pairs)
 * 4. Repeat the above steps if end is not reached.
 */

// FIXME : http://www.geeksforgeeks.org/stock-buy-sell/
public class StockBuySellMaxProfit {

    static class Interval {
        int buy;
        int sell;
    }


    // This function finds the buy sell schedule for maximum profit
    static void stockBuySell(int price[], int n) {
        // Prices must be given for at least two days
        if (n == 1)
            return;

        int count = 0; // count of solution pairs

        // solution vector
        Interval[] sol = new Interval[n / 2 + 1];

        // Traverse through given price array
        int i = 0;

        while (i < n - 1) {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            // Store the index of minima
            sol[count] = new Interval();
            sol[count].buy = i++;

            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            // Store the index of maxima
            sol[count] = new Interval();
            sol[count].sell = i - 1;

            // Increment count of buy/sell pairs
            count++;
        }
        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock will make profit\n");
        else {
            for (int j = 0; j < count; j++)
                System.out.printf("Buy on day: %d\t Sell on day: %d\n", sol[j].buy, sol[j].sell);
        }

        return;
    }

    public static void main(String[] args) {
        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;

        // fucntion call
        stockBuySell(price, n);
    }
}