/*A table composed of N x M cells, each having a certain quantity of apples, is given. You start from the upper-left corner. 
At each step you can go down or right one cell. Find the maximum number of apples you can collect.*/


public class MaxSumOnPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arry[][]= {
                 	{0,0,0,0,0},
                   {0,1,2,3,4},
                   {10,10,10,1,1},
                   {0,9,9,9,9}
                 };
		 System.out.println(maxSum(arry));
	}
	
	public static int maxSum(int arry[][]){
		int rowLength = arry.length;
		int columnLength = arry[arry.length-1].length;
		for(int i=1;i<arry.length;i++)
			for(int j=1;j<arry[arry.length-1].length;j++){
				if(arry[i-1][j]>arry[i][j-1])
					arry[i][j] += arry[i-1][j];
				
				else
					arry[i][j] += arry[i][j-1];
			}
		
		return arry[rowLength-1][columnLength-1];
	}

}
