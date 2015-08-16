/**
 * Created by chanumolu on 6/27/15.
 */

/**
 * * Given an image represented by an NxN matrix, where each pixel is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * Rotate NxN matrix by 90 degrees in-place
 *
 * this example rotates ccw
 *
 * TODO:bug in code
 */
public class RotateNxNMatrix90InPlace {


    public static void rotateBy90(int[][] image) {

        if(image.length != image[0].length) {
            throw new IllegalArgumentException("The matrix must be square.");
        }

        int n = image.length;
        int f = (int)Math.floor(n/2);
        int c = (int)Math.ceil(n/2);

        // rotate 4 "pixels" of the image at a time
        for(int x = 0; x < f; x++) {
            for(int y = 0; y < c; y++) {
                int temp = image[x][y];
                image[x][y] = image[y][image.length-1-x];
                image[y][image.length-1-x] = image[image.length-1-x][image.length-1-y];
                image[image.length-1-x][image.length-1-y] = image[image.length-1-y][x];
                image[image.length-1-y][x] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] img3 = { {1, 2, 3},
                {3, 4, 5},
                {6, 7, 8} };
        int[][] img4 = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16} };

        System.out.println("Image 3: ");
        printMatrix(img3);
        rotateBy90(img3);
        System.out.println("Rotated Image: ");
        printMatrix((img3));
        System.out.println();
        System.out.println("Image 4: ");
        printMatrix(img4);
        rotateBy90(img4);
        System.out.println("Rotated Image: ");
        printMatrix((img4));



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


/**
 *
 * without using temp variable
 *
 * def rot2(a):
 n = len(a)
 c = (n+1) / 2
 f = n / 2
 for x in range(c):
 for y in range(f):
 a[x][y] = a[x][y] ^ a[n-1-y][x]
 a[n-1-y][x] = a[x][y] ^ a[n-1-y][x]
 a[x][y] = a[x][y] ^ a[n-1-y][x]

 a[n-1-y][x] = a[n-1-y][x] ^ a[n-1-x][n-1-y]
 a[n-1-x][n-1-y] = a[n-1-y][x] ^ a[n-1-x][n-1-y]
 a[n-1-y][x] = a[n-1-y][x] ^ a[n-1-x][n-1-y]

 a[n-1-x][n-1-y] = a[n-1-x][n-1-y]^a[y][n-1-x]
 a[y][n-1-x] = a[n-1-x][n-1-y]^a[y][n-1-x]
 a[n-1-x][n-1-y] = a[n-1-x][n-1-y]^a[y][n-1-x]
 */