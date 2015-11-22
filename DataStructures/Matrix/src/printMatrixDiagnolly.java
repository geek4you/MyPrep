
public class PrintMatrixDiagnolly {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub


    }

    static void PrintMatrixDiagnolly(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // number of lines in output
        int numLines = rows + cols - 1;

        // print each line
        for (int line = 1; line <= numLines; line++) {

            // starting col for the line
            /* Get column index of the first element in this line of output.
           The index is 0 for first ROW lines and line - ROW for remaining
           lines  */
            int startCol = Math.min(0,line-rows);


            // number of elements in the line
            /* Get count of elements in this line. The count of elements is
           equal to minimum of line number, COL-start_col and ROW */
            int count = min(line,cols-startCol,rows);

            for(int j=0;j<count;j++){
                System.out.print(matrix[Math.min(line,rows)-j-1][startCol+j]);
            }
        }
    }

    static int min(int x, int y , int z){
        if(x<y && x<z)
            return x;
        if(y<z)
            return y;
        return z;
    }

}
