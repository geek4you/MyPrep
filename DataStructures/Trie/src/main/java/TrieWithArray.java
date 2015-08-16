/**
 * Created by chanumolu on 7/7/15.
 */

interface alphaSize{
    int ALBHABETSIZE = 26;
}

public class TrieWithArray{

    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        trie tri = new trie();
        // Construct trie

        //insert
        for(int i = 0; i < (keys.length); i++)
        {

            char r[] = keys[i].toCharArray();
            tri.insert(r);
        }

        //search
        System.out.println(tri.search("any".toCharArray()));
        System.out.println(tri.search("byes".toCharArray()));
        System.out.println(tri.search("their".toCharArray()));

        //words with given prefix
        System.out.println(tri.wordsWithPrefix("an".toCharArray()));
        System.out.println(tri.wordsWithPrefix("th".toCharArray()));
    }




}

class trieNode implements alphaSize
{
    boolean isEnd;
    int prefixCount=0;
    trieNode[] children= null;

    public trieNode() {
        prefixCount=0;
        isEnd = false;
        children = new trieNode[ALBHABETSIZE];
        for(int i=0;i<ALBHABETSIZE;i++){
            children[i] = null;
        }
    }

};

//trie ADT
class trie
{
    trieNode root;


    trie(){
        root = new trieNode();

    }

    //insert
    void insert(char key[]){
        int index;
        trieNode tCrawl = this.root;
        tCrawl.prefixCount++;

        for(int level = 0; level < key.length; level++ )
        {
            index = CHAR_TO_INDEX(key[level]);
            if( tCrawl.children[index]==null )
            {
                tCrawl.children[index] = new trieNode();

            }
            tCrawl = tCrawl.children[index];
            tCrawl.prefixCount++;
        }

        // mark last node as leaf
        tCrawl.isEnd = true;
        //System.out.println("YES");
    }

    //search
    boolean search(char key[]){
        int index;
        trieNode tCrawl = this.root;

        for(int level=0;level<key.length;level++){
            index = CHAR_TO_INDEX(key[level]);
            if(tCrawl.children[index]==null){
                System.out.println("tCrawl.children is null for index: "+index +" i.e for child: "+(char)('a'+index));
                return false;
            }
            tCrawl = tCrawl.children[index];

        }
        //System.out.println(tCrawl.value);
        return tCrawl.isEnd;
    }


    //num of words with given prefix
    int wordsWithPrefix(char prefix[]){
        int index;
        trieNode tCrawl=this.root;

        for(int level=0;level<prefix.length;level++){
            index = CHAR_TO_INDEX(prefix[level]);
            if(tCrawl.children[index]==null){
                return 0;
            }
            tCrawl = tCrawl.children[index];
        }
        return tCrawl.prefixCount;
    }


    //Converts key current character into index
    //use only 'a' through 'z' and lower case
    static int CHAR_TO_INDEX(char ch){
        return (int)ch - (int)'a';
    };
};

