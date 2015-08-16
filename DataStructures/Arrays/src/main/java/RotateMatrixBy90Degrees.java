/**
 * Created by chanumolu on 6/25/15.
 */
public class RotateMatrixBy90Degrees {

    public static int[][] rotate90(int[][] arry) {

        int[][] result = new int[arry.length][arry[0].length];

        // read the array down to up in each row and place in the result array
        int k= 0 , l=0;
        for (int j = 0; j < arry[0].length; j++) {
            for (int i = arry.length - 1; i >= 0; i--) {

                result[j][result[0].length-1-i] = arry[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arry = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrix(arry);
        System.out.println("rotated:");
        printMatrix(rotate90(arry));

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
