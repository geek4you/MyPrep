
public class MySpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { {1,  2,  3,  4,  5,  6},
				{7,  8,  9,  10, 11, 12},
				{13, 14, 15, 16, 17, 18}
		};
		printSpiral(a,3,6);
	}
	
	public static void printSpiral(int a[][],int M,int N){
		int i=0, j=0, l=M, k=N;
		int num2process = N*M;
		while(num2process>0){
			//print top row
			while(j<k){
				System.out.println(a[i][j]);
				j++; 
				num2process--;
			}
			j--; i++;
			//print last column
			while(i<l){
				System.out.println(a[i][j]);
				i++;
				num2process--;
			}
			i--; j--;
			
			//print last row
			while(j>=N-k){
				System.out.println(a[i][j]);
				j--; num2process--;
			}
			i--; j++;
			
			//print first column
			while(i>M-l){
				System.out.println(a[i][j]);
				i--;
				num2process--;
			}
			i++;j++;
			l=l-1;
			k=k-1;
		}
	}

}
