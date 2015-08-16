/**
 * Created by chanumolu on 6/25/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 * Given an n x n matrix, where every row and column is sorted in increasing order. Given a number x,
 * how to decide whether this x is in the matrix. The designed algorithm should have linear time complexity.
 * <p>
 * 1) Start with top right element
 * 2) Loop: compare this element e with x
 * ….i) if they are equal then return its position
 * …ii) e < x then move it to down (if out of bound of matrix then break return false)
 * ..iii) e > x then move it to left (if out of bound of matrix then break return false)
 * 3) repeat the i), ii) and iii) till you find element or returned false
 */
public class SearchInRowWiseColumnWiseSortedMatrix {

    public static boolean search(int[][] arry, int key) {
        int i = 0, j = arry.length-1;
        while(i < arry.length && j >=0){
                if (key == arry[i][j]) {
                    return true;
                } else if (key > arry[i][j]) {
                    i++;
                } else {
                    j--;
                }
            }

        return false;
    }

    public static void main(String[] args) {
        int[][] arry = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        System.out.println(search(arry,31));
        System.out.println(search(arry,32));
    }


}
