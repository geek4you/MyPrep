/**
 * Created by chanumolu on 6/24/15.
 */

/**
 * Maximum size square sub-matrix with all 1s
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 * <p>
 * For example, consider the below binary matrix.
 * <p>
 * <p>
 * 0  1  1  0  1
 * 1  1  0  1  0
 * 0  1  1  1  0
 * 1  1  1  1  0
 * 1  1  1  1  1
 * 0  0  0  0  0
 * The maximum square sub-matrix with all set bits is
 * <p>
 * 1  1  1
 * 1  1  1
 * 1  1  1
 * Algorithm:
 * Let the given binary matrix be M[R][C]. The idea of the algorithm is to construct an auxiliary size matrix S[][]
 * in which each entry S[i][j] represents size of the square sub-matrix with all 1s including M[i][j] where M[i][j] is
 * the rightmost and bottommost entry in sub-matrix.
 * <p>
 * 1) Construct a sum matrix S[R][C] for the given M[R][C].
 * a)	Copy first row and first columns as it is from M[][] to S[][]
 * b)	For other entries, use following expressions to construct S[][]
 * If M[i][j] is 1 then
 * S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
 * Else //If M[i][j] is 0
 * S[i][j] = 0
 * 2) Find the maximum entry in S[R][C]
 * 3) Using the value and coordinates of maximum entry in S[i], print
 * sub-matrix of M[][]
 * For the given M[R][C] in above example, constructed S[R][C] would be:
 * <p>
 * 0  1  1  0  1
 * 1  1  0  1  0
 * 0  1  1  1  0
 * 1  1  2  2  0
 * 1  2  2  3  1
 * 0  0  0  0  0
 */
public class MaximumSizeSubSquareAll1s {

    public static int maxSubMatrix(int[][] arry) {

        int[][] s = new int[arry.length][arry[0].length];
        //copy first row and column
        for (int i = 0; i < arry[0].length; i++)
            s[0][i] = arry[0][i];
        for (int j = 0; j < arry.length; j++)
            s[j][0] = arry[j][0];

        for (int i = 1; i <= arry.length - 1; i++)
            for (int j = 1; j <= arry[0].length - 1; j++) {
                if (arry[i][j] == 1) {
                    s[i][j] = min(s[i - 1][j], s[i - 1][j - 1], s[i][j - 1]) + 1;
                } else
                    s[i][j] = 0;
            }

        System.out.println("S matrix:");
        for (int i = 0; i < arry.length; i++) {
            System.out.println();
            for (int j = 0; j < arry[0].length; j++)
                System.out.print(s[i][j] + " ");
        }

        // now scan the s array and return the max value
        int maxSub = 0;
        for (int i = 0; i <= arry.length - 1; i++)
            for (int j = 0; j <= arry[0].length - 1; j++) {
                if (maxSub < s[i][j])
                    maxSub = s[i][j];
            }

        return maxSub;
    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else if (b < c)
            return b;
        else
            return c;
    }

    public static void main(String[] args) {
        int[][] arry = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        System.out.println("Max sub array with 1's: " + maxSubMatrix(arry));
    }
}
