import java.util.HashMap;
import java.util.Map;

//url:http://www.geeksforgeeks.org/print-unique-rows/
/**Given a binary matrix, print all unique rows of the given matrix.

Input:
	{0, 1, 0, 0, 1}
        {1, 0, 1, 1, 0}
        {0, 1, 0, 0, 1}
        {1, 1, 1, 0, 0}
Output:
	0 1 0 0 1 
	1 0 1 1 0 
	1 1 1 0 0   */

public class PrintUniqueRowsInMatrix {
	public static void main(String args[]){
		int[][] matrix ={{0, 1, 0, 0, 1},
        {1, 0, 1, 1, 0},
        {0, 1, 0, 0, 1},
        {1, 1, 1, 0, 0}};
		
		printUniqueRows(matrix);
	}
	
	public static void printUniqueRows(int[][] matrix){
		trie2<Integer> tri= new trie2<Integer>();
		
		for(int i=0;i<matrix.length;i++){
			if(!tri.search(matrix[i])){
				printRow(matrix[i]);
				tri.insert(matrix[i]);
			}
		}
	}
	
	static void printRow(int[] row){
		for(int i=0;i<row.length;i++){
			System.out.print(row[i]+" ");
		}
		System.out.println();
	}
}

//here trie contains only 2 children. 0 or 1 as matrix is binary.
class trie2<E extends Comparable<E>>{
	TrieNode2 root;
	
	trie2(){
		root =  new TrieNode2();
	}
	
	void insert(int[] keys){
		TrieNode2 tcrawl = root;
		for(int key: keys){
			if(!tcrawl.children.containsKey(key)){
				tcrawl.children.put(key, new TrieNode2());
			}
			
			tcrawl=tcrawl.children.get(key);
		}
		tcrawl.isEnd=true;
	}
	
	boolean search(int[] keys){
		TrieNode2 tcrawl = root;
		for(int key: keys){
			if(!tcrawl.children.containsKey(key)){
				return false;
			}
			tcrawl=tcrawl.children.get(key);
		}
		if(tcrawl.isEnd)
			return true;
		
		return false;
	}
}

class TrieNode2{
	boolean isEnd;
	Map<Integer,TrieNode2> children;
	
	TrieNode2(){
		this.isEnd=false;
		this.children = new HashMap<Integer,TrieNode2>();
	}
	
}