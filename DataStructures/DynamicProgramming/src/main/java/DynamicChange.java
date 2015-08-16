/**
 * Created by Pradeep on 5/20/15.
 */
public class DynamicChange {

    /**
     * @param args
     */
    static int[] coin_denom;
    static int[] s;

    public static void coin_change(int[] coins, int amount, int[] availability) {
        coin_denom = new int[amount + 1];
        coin_denom[0] = 0;
        s = new int[amount + 1];
        int min;
        int coin = 0;

        for (int i = 1; i <= amount; i++) {
            min = 10000;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int temp = i - coins[j];
                    if ((1 + coin_denom[temp]) < min) {
                        min = 1 + coin_denom[temp];
                        coin = j;
                    }
                }
            }
            coin_denom[i] = min;
            s[i] = coin;
        }

    }

    public static void myMakeChangeLimitedCoins(int[] coins,
                                                int[] availability, int amount) {
        int[] coin_denom = new int[amount + 1];
        coin_denom[0] = 0;
        s = new int[amount + 1];

        int[][] trackAmount = new int[amount + 1][coins.length];

        for (int i = 0; i < coins.length; i++) {
            trackAmount[0][i] = availability[i];
        }
        int coin = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int temp = i - coins[j];

                    if ((1 + coin_denom[temp]) < min
                            && trackAmount[temp][j] > 0) {
                        min = 1 + coin_denom[temp];
                        coin = j;
                        trackAmount[i][j] = trackAmount[temp][j] - 1;
                    } else {

                        trackAmount[i][j] = trackAmount[temp][j];
                    }

                } else {
                    trackAmount[i][j] = trackAmount[0][j];
                }
            }
            coin_denom[i] = min;
            s[i] = coin;
        }

        if (coin_denom[amount] == Integer.MAX_VALUE)
            System.out.println("No solution");
        else {
            while (amount > 0) {
                System.out.println(coins[s[amount]] + ",");
                amount = amount - coins[s[amount]];
            }
        }
    }
    public static void make_changes(int amount, int[] coins) {
        System.out.println(coin_denom[amount] + " Coins");
        while (amount > 0) {
            System.out.println(coins[s[amount]] + ",");
            amount = amount - coins[s[amount]];
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] coins = { 20, 10, 5, 4, 1 };
        int[] available = { 1, 3, 1, 7, 15 };
        int amount = 47;
        // coin_change(coins, amount, available);
        // make_changes(amount, coins);
        myMakeChangeLimitedCoins(coins, available, 47);
    }

}
