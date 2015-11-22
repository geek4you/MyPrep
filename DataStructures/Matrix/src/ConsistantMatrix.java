/*Given a NxN Matrix “A”, which contains elements such that every row is sorted (left to right) and 
every column is sorted (top to bottom) in ascending order. Such a matrix is called consistent matrix

Now an element A[j] is set to infinity. Devise an efficient algorithm to make the matrix consistent again.*/
public class ConsistantMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { {1,  2,  3,  4,  5,  6},
				{7,  8,  9,  10, 11, 12},
				{13, 14, 15, 16, 17, 18}
		};
		
		System.out.println(a.length);
		System.out.println(a[a.length-1].length);
	}

}
