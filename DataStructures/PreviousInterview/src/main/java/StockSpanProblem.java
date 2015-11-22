/**
 * Created by chanumolu on 10/28/15.
 */


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need
 * to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the
 * given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for
 * corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * <p>
 * A Linear Time Complexity Method
 * We see that S[i] on day i can be easily computed if we know the closest day preceding i, such that the price is
 * greater than on that day than the price on day i. If such a day exists, let’s call it h(i), otherwise, we define h(i) = -1.
 * <p>
 * To implement this logic, we use a stack as an abstract data type to store the days i, h(i), h(h(i)) and so on.
 * When we go from day i-1 to i, we pop the days when the price of the stock was less than or equal to price[i] and then
 * push the value of day i back into the stack.
 */

public class StockSpanProblem {

    public static void calculateSpan(int[] price, int[] span) {

        // create stack and push first element into the stack
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);

        // Span value of first element is always 1
        span[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < price.length; i++) {
            // Pop elements from stack while stack is not empty and top of
            // stack is smaller than price[i]
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]){
                stack.pop();
            }

            // If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
            // is greater than elements after top of stack
            span[i] = (stack.isEmpty())? (i + 1) : (i - stack.peek());

            // Push this element to stack
            stack.push(i);
        }

    }

    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        int S[] = new int[price.length];

        // Fill the span values in array S[]
        calculateSpan(price,  S);

        // print the calculated span values
        for(int i : S){
            System.out.printf("%d",S[i]);
        }

    }
}
