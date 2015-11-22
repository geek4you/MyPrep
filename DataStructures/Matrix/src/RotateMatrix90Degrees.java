
public class RotateMatrix90Degrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { {1,  2,  3,  4,  5,  6},
				{7,  8,  9,  10, 11, 12},
				{13, 14, 15, 16, 17, 18}
		};
		printMatrix(a,3,6);
		printMatrix(rotate90(a,3,6),6,3);
		
	}
	public static int[][] rotate90(int[][] Matrix, int M, int N){
		int [][] matrix90 =new int[N][M];
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				matrix90 [j][M-i-1] = Matrix[i][j];
			}
		}
		return matrix90;
		
	}
	
	public static void printMatrix(int [][]a, int M, int N){
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(a[i][j]);
			}
			System.out.println();	
		}
			
		
	}

}
