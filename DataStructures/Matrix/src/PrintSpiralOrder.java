
public class PrintSpiralOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { {1,  2,  3,  4,  5,  6},
				{7,  8,  9,  10, 11, 12},
				{13, 14, 15, 16, 17, 18}
		};

		spiralPrint(6, 3, a);
	}

	private static void spiralPrint(int ySize, int xSize, int[][] matrix) {
		// TODO Auto-generated method stub

		int i,  k = 0, l = 0;
		xSize--;  ySize--;      

		while(k <= xSize && l <= ySize){
			for(i = l; i <= ySize; ++i) {
				System.out.print(matrix[k][i]+ " ");
			}           
			k++;

			for(i = k; i <= xSize; ++i) {
				System.out.print(matrix[i][ySize] + " ");
			}
			ySize--;

			for(i = ySize; i >= l; --i) {
				System.out.print(matrix[xSize][i] + " ");
			}
			xSize--;


			for(i = xSize; i >= k; --i) {
				System.out.print(matrix[i][l] + " ");
			}
			l++;
		}
	}

}

