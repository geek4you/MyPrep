/**
 * Created by chanumolu on 8/3/15.
 */

/*
There are are 26 English upper and lower-case letters. Consider the encoding where vowels are mapped to numbers as follows: (a=1, e=5,
i=9, o=15, u=21, y=25 or 0). A vowel sequence is a maximal substring of consecutive vowels. A vowel product is the product of the vowel
encoding of all vowels in a vowel sequence.  The vowel product sum is the sum of the vowel product of all vowel sequences in the string.
A letter in [AEIOUaeiou] is always a vowel. 'y' or 'Y' is a vowel if it is preceded by a consonant; otherwise, it is a consonant. An
ASCII character is either a vowel, a consonant, or a  non-letter. Treat all upper-case letters the same as lower-case letters.
For examples:
"Google Guy" has vowel sequences of "oo", "e", and "u". Its score is 15 * 15 + 5 + 21 = 251.
"Yyyyy" has vowel sequences of "y" and "y". Its score is 25 + 25 = 50.
"myopia" has vowel sequences of "yo" and "ia". Its score is 25 * 15+ 9 * 1 = 384.
"Quietly" has vowel sequences of "uie" and "y". Its score is 21 * 9 * 5 + 25 = 970.
"I'm Feeling Yucky!" has vowel sequences of "I", "ee", "i", "u", and "y". Its score 9 + 5 * 5 + 9 + 21 + 25 = 89.  The first 'Y' in
"Yucky" is preceded by a space (non-letter), so it is not considered a vowel.

solution: define the vowel checking rule correctly. Then just one scan.
O(n) time, O(1) space

*/
public class VowelProduct {

    public static boolean checkBasicVowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
            return true;
        }
        return false;
    }

    public static boolean checkVowel(String str, int index) {
        char c = str.charAt(index);

        if (checkBasicVowel(c)) {
            return true;
        }

        if (index == 0)
            return false;

        if (c == 'y' || c == 'Y') {
            if(!checkVowel(str,index-1) && Character.isLetter(c) && str.charAt(index-1)!=' '){ // dont forget to check for space before y/Ys
                return true;
            }else{
                return false;
            }
        }

        return false;
    }

    public static int getValue(char c) {

        int value = c - 'a' + 1;
        if (value >= 0) return value;
        return c - 'A' + 1;
    }

    public static  int calculateVowelProductSum(String str){

        boolean continuous = false;
        int result =0, prevVal = -1 ;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(checkVowel(str,i)){

                if(continuous){
                    result = result-prevVal;
                    prevVal = (prevVal*getValue(c));
                    result = result + prevVal;
                }else{
                    prevVal = getValue(c);
                    result = result+prevVal;
                }
                continuous = true;
            }else{
                continuous = false;
                prevVal = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str1 = "Google Guy";
        String str2 = "myopia";
        String str3 = "I'm Feeling Yucky!";
        //System.out.println(calculateVowelProductSum(str1));
        //System.out.println(calculateVowelProductSum(str2));
        System.out.println(calculateVowelProductSum(str3));
    }
}
