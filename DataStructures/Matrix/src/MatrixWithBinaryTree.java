import java.util.Arrays;

/* There is a binary tree of size N. All nodes are numbered between 1-N(inclusive). 
 There is a N*N integer matrix Arr[N][N], all elements are initialized to zero. 
 So for all the nodes A and B, put Arr[A][B] = 1 if A is an ancestor of B (NOT just the immediate ancestor).*/


public class MatrixWithBinaryTree {
	public static void main(String[] args) {
		
		int[][] array = new int [4][4];
		for(int i=0;i<4;i++)
			Arrays.fill(array[i], 0);
		
		BNode root = new BNode(1);
		root.left=new BNode(2);
		root.right= new BNode(3);
		root.left.left=new BNode(4);
		
		markAncestorsInMatrix(array, root);
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[array.length-1].length;j++){
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
			
	}
	
	public static void markAncestorsInMatrix(int[][] array, BNode root){
		if(root==null)
			return;
		
		if(root.left!=null){
			array[root.data-1][root.left.data-1] = 1;
			for(int i=0;i<array.length;i++){
				if(array[i][root.data-1]==1){
					array[i][root.left.data-1]=1;
				}
			}
			
			markAncestorsInMatrix(array, root.left);
		}
		
		if(root.right!=null){
			array[root.data-1][root.right.data-1] = 1;
			for(int i=0;i<array.length;i++){
				if(array[i][root.data-1]==1){
					array[i][root.right.data-1]=1;
				}
			}
			
			markAncestorsInMatrix(array, root.right);
		}
		
		
	}
	

}

class BNode{
	int data;
	BNode left;
	BNode right;
	
	BNode(int value){
		this.data = value;
		left = null;
		right=null;
	}
	
	
}