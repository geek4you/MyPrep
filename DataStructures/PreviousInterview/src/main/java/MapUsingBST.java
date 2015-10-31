/**
 * Snapchat Interview
 */
/**
Implement Map Using BST
 V get(K key)
 void put(K key, V value)
 int size()

 * @param <K>
 * @param <V>
 */

public class MapUsingBST<K extends Comparable<K>, V>{
    Node root;
    int count;

    public MapUsingBST(){
        root =null;
        count =0;
    }

    public MapUsingBST(Node node){
        root = node;
        count =0;
    }

    public  V get(Node root , K key){
        if(null == root){
            return null;
        }

        if(root.key == key){
            return (V)root.value;
        }

        if(root.left != null && root.key.compareTo(key)>0 ){
            return get(root.left,key);
        }

        if(root.right != null && root.key.compareTo(key) <0){

            return get(root.right,key);
        }

        return null;
    }

    public  void put(Node root, K key, V value){
        if(null == root){
            root = new Node(key,value);
            count++;
        }

        if(root.key == key){
            root.value = value;
        }

        if(root.key.compareTo(key)>0){
            put(root.left, key, value);
        }

        if(root.key.compareTo(key)<0){
            put (root.right, key, value);
        }

        return;

    }

    public int size(Node root){
        //if(null == root)
        //  return 0;

        //return 1+size(root.left)+size(root.right);
        return count;
    }

    public static void main(String[] args){
        MapUsingBST<Integer,Integer> map = new MapUsingBST<Integer,Integer>();
        map.put(map.root,new Integer(10),new Integer(10));
        //map.put(14,20);
        //map.put(15,30);

        System.out.println(map.get(map.root,new Integer(14)));
    }


    static class Node<K extends Comparable<K>,V> {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left =null;
            right = null;
        }
    }
}



