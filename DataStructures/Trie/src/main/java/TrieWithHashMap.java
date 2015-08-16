/**
 * Created by chanumolu on 7/7/15.
 */


interface alphabetSize {
    int ALPHABETSIZE = 10;
}

public class TrieWithHashMap {
    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "theire", "answer", "any", "by", "bye", "their"};
        Trie1 tri = new Trie1();
        // Construct trie

        //insert
        for(int i = 0; i < (keys.length); i++)
        {

            char r[] = keys[i].toCharArray();
            tri.insert(keys[i]);
        }

        //search
        System.out.println(tri.search("any"));
        System.out.println(tri.search("byes"));
        System.out.println(tri.search("their"));

        //words with given prefix
        System.out.println(tri.wordsWithPrefix("an"));
        System.out.println(tri.wordsWithPrefix("th"));
    }
}


class Trie1 implements alphabetSize {
    TrieNode root;

    Trie1() {
        root = new TrieNode();
    }

    public void insert(String key) {
        char[] chAry = key.toCharArray();
        TrieNode tCrawl = root;

        for (int level = 0; level < key.length(); level++) {
            // if char is not present in the children , put it.
            if(!tCrawl.children.containsKey(chAry[level])){
                tCrawl.children.put(chAry[level],new TrieNode());
            }

            tCrawl = tCrawl.children.get(chAry[level]);
            tCrawl.prefixCount++;

        }

        tCrawl.isEnd = true;
    }

    public boolean search(String key){
        char[] chAry = key.toCharArray();

        TrieNode tCrawl = root;

        for(int level=0; level<key.length();level++){
            if(!tCrawl.children.containsKey(chAry[level])){
                return false;
            }

            tCrawl = tCrawl.children.get(chAry[level]);
        }

        return tCrawl.isEnd;
    }

    public int wordsWithPrefix(String key){
        char[] chAry = key.toCharArray();
        TrieNode tCrawl = root;
        for(int level=0; level<key.length();level++){
            if(!tCrawl.children.containsKey(chAry[level])){
                return 0;
            }
            tCrawl = tCrawl.children.get(chAry[level]);
        }

        return tCrawl.prefixCount;

    }
}