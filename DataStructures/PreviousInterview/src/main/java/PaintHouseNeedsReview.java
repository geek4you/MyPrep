/**
 * Created by chanumolu on 10/28/15.
 */

import java.util.Arrays;

/**
 * Ooyala Interview
 */
/**
 * There are a row of houses, each house can be painted with three colors red, blue and green.
 * The cost of painting each house with a certain color is different. You have to paint all the houses
 * such that no two adjacent houses have the same color. You have to paint the houses with minimum cost.
 * How would you do it?
 * <p>
 * Note: Painting house-1 with red costs different from painting house-2 with red. The costs are different for each
 * house and each color.
 * <p>
 * <p>
 * Solution using dynamic programing.
 * The solution is as folows (calc(int, int) function):
 * 1. If a best solution was found, use it.
 * 2. Select one color not forbiden;
 * 3. Solve the problem for n-1 houses.
 * 4. get the best result adding best result for n-1 to current cost.
 * 5. see if it is the current minimum when you add current color cost
 * 6. update minimum if needed.
 * 7. save best result.
 * <p>
 * Time complexity: Colors*Houses.
 * Space complexity: Colors*Houses.
 * Is easy to see it, if you realize that the runtime cost is the time to fill the best solution matrix,
 * sized Colors*Houses.
 * By the way, for the problem stated above, the solution is:
 * Colors: [1, 0, 2, 1, 0, 1] (G, R, B, G, R, G)
 * Cost: 18
 */

public class PaintHouseNeedsReview {
    public class BestResult {
        public int[] colors;
        public int cost;

        public BestResult(int[] colors, int cost) {
            this.colors = colors;
            this.cost = cost;
        }

    }

    private int[][] cost;
    private BestResult[][] best;

    public PaintHouseNeedsReview(int[][] cost) {
        this.cost = cost;
        this.best = new BestResult[cost.length][cost[0].length];
    }

    public BestResult calc() {
        return calc(cost[0].length, -1);
    }

    private BestResult calc(int n, int forbiden) {
        if (forbiden >= 0 && best[forbiden][n - 1] != null)
            return best[forbiden][n - 1];
        BestResult min = null;
        for (int c = 0, h = cost[0].length - n; c < cost.length; ++c) {
            if (c != forbiden) {
                if (n == 1) {
                    if (min == null || min.cost > cost[c][h]) {
                        min = new BestResult(new int[]{c}, cost[c][h]);
                    }
                } else {
                    BestResult next = calc(n - 1, c);
                    if (min == null
                            || min.cost > (next.cost + cost[c][h])) {
                        min = new BestResult(new int[next.colors.length + 1],
                                next.cost + cost[c][h]);
                        min.colors[0] = c;
                        System.arraycopy(next.colors, 0,
                                min.colors, 1, next.colors.length);
                    }
                }
            }
        }
        if (forbiden >= 0)
            best[forbiden][n - 1] = min;
        return min;
    }

    public static void main(String[] args) {
        int[][] cost = new int[][]{
                new int[]{7, 3, 8, 6, 1, 2},
                new int[]{5, 6, 7, 2, 4, 3},
                new int[]{10, 1, 4, 9, 7, 6}
        };
        PaintHouseNeedsReview calc = new PaintHouseNeedsReview(cost);
        BestResult bestResult = calc.calc();
        System.out.println("Colors: " + Arrays.toString(bestResult.colors));
        System.out.println("Cost: " + bestResult.cost);
    }
}

