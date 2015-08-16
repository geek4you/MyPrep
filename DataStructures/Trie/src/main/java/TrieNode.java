import java.util.HashMap;
import java.util.Map;

/**
 * Created by chanumolu on 7/7/15.
 */

public class TrieNode {

    int prefixCount;
    Map<Character,TrieNode> children;
    boolean isEnd;

    TrieNode(){
        children = new HashMap<Character,TrieNode>();
        prefixCount =0;
        isEnd = false;
    }

}
