/**
 * Created by chanumolu on 10/28/15.
 */

/**
 * Given a sequence of words, print all anagrams together | Set 1
 Given an array of words, print all anagrams together.
 For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then output may be “cat tac act dog god”.

 Method 1:
 A simple method is to create a Hash Table. Calculate the hash value of each word in such a way that all anagrams have
 the same hash value. Populate the Hash Table with these hash values. Finally, print those words together with same hash
 values. A simple hashing mechanism can be modulo sum of all characters. With modulo sum, two non-anagram words may have
 same hash value. This can be handled by matching individual characters.

 Method 2:
 Following is another method to print all anagrams together. Take two auxiliary arrays, index array and word array.
 Populate the word array with the given sequence of words. Sort each individual word of the word array.
 Finally, sort the word array and keep track of the corresponding indices. After sorting, all the anagrams cluster together.
 Use the index array to print the strings from the original array of strings.

 Let us understand the steps with following input Sequence of Words:

 "cat", "dog", "tac", "god", "act"
 1) Create two auxiliary arrays index[] and words[]. Copy all given words to words[] and store the original indexes in index[]

 index[]:  0   1   2   3   4
 words[]: cat dog tac god act
 2) Sort individual words in words[]. Index array doesn’t change.

 index[]:   0    1    2    3    4
 words[]:  act  dgo  act  dgo  act
 3) Sort the words array. Compare individual words using strcmp() to sort

 index:     0    2    4    1    3
 words[]:  act  act  act  dgo  dgo
 4) All anagrams come together. But words are changed in words array. To print the original words, take index from the index array and use it in the original array. We get

 "cat tac act dog god"

 Time: Let there be N words and each word has maximum M characters. The upper bound is O(NMLogM + MNLogN).
 Step 2 takes O(NMLogM) time. Sorting a word takes maximum O(MLogM) time. So sorting N words takes O(NMLogM) time.
 step 3 takes O(MNLogN) Sorting array of words takes NLogN comparisons. A comparison may take maximum O(M) time.
 So time to sort array of words will be O(MNLogN).

 Method 3:

 Trie data structure can be used for a more efficient solution. Insert the sorted order of each word in the trie.
 Since all the anagrams will end at the same leaf node. We can start a linked list at the leaf nodes where each node
 represents the index of the original array of words. Finally, traverse the Trie. While traversing the Trie, traverse
 each linked list one line at a time. Following are the detailed steps.

 1) Create an empty Trie
 2) One by one take all words of input sequence. Do following for each word
 …a) Copy the word to a buffer.
 …b) Sort the buffer
 …c) Insert the sorted buffer and index of this word to Trie. Each leaf node of Trie is head of a Index list. The
 Index list stores index of words in original sequence. If sorted buffe is already present, we insert index of this
 word to the index list.
 3) Traverse Trie. While traversing, if you reach a leaf node, traverse the index list. And print all words using the
 index obtained from Index list.

 */
public class PrintAllAnagramsTogether {
}
