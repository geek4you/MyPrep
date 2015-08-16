/**
 * Created by chanumolu on 6/27/15.
 */

/**
 * /**
 * Write an algorithm such that if an element of an MxN matrix is 0,
 * its entire row and column are set to 0.
 *
 */
public class ZerosMatrix {

    /**
     * Zero the entire row and column of an element if that element is zero.
     * @param matrix
     */
    public static void zero(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        // store which rows and columns have zeroes
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // set rows to 0
        for(int i = 0; i < rows.length; i++) {
            if(rows[i]) {
                for(int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set cols to 0
        for(int j = 0; j < cols.length; j++) {
            if(cols[j]) {
                for(int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] img3 = { { 1, 2, 3 }, { 3, 0, 5 }, { 6, 7, 8 } };
        int[][] img4 = { { 0, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        printMatrix(img3);
        System.out.println();
        zero(img3);
        printMatrix(img3);

        System.out.println();

        printMatrix(img4);
        System.out.println();
        zero(img4);
        printMatrix(img4);

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }
    }
}
