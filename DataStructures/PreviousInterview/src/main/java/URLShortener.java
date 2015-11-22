/**
 * Created by chanumolu on 11/14/15.
 */

/**
 * OOYALA
 */

/*
How to design a tiny URL or URL shortener?
How to design a system that takes big URLs like
“http://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/” and converts them into a short 6
character URL. It is given that URLs are stored in database and every URL has an associated integer id.

One important thing to note is, the long url should also be uniquely identifiable from short url. So we need a
Bijective Function

One Simple Solution could be Hashing. Use a hash function to convert long string to short string. In hashing, that
may be collisions (2 long urls map to same short url) and we need a unique short url for every long url so that we
can access long url back.

A Better Solution is to use the integer id stored in database and convert the integer to character string that is
at most 6 characters long. This problem can basically seen as a base conversion problem where we have a 10 digit
input number and we want to convert it into a 6 character long string.

Below is one important observation about possible characters in URL.

A URL character can be one of the following
1) A lower case alphabet [‘a’ to ‘z’], total 26 characters
2) An upper case alphabet [‘A’ to ‘Z’], total 26 characters
3) A digit [‘0′ to ‘9’], total 10 characters

There are total 26 + 26 + 10 = 62 possible characters.

So the task is to convert a decimal number to base 62 number.

To get the original long url, we need to get url id in database. The id can be obtained using base 62 to decimal
conversion.


 */
public class URLShortener {

    // Function to generate a short url from intger ID
    // decimal to base 62 number conversion
    static String idToShortUrl(int id) {

        // Map to store 62 possible characters
        String st = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] map = st.toCharArray();

        StringBuffer shortUrl = new StringBuffer();

        // Convert given integer id to a base 62 number
        while (id != 0) {
            // use above map to store actual character
            // in short url
            shortUrl.append(map[id % 62]);
            id = id / 62;
        }

        // Reverse shortURL to complete base conversion
        String returnVal = reverseString(new String(shortUrl));
        return returnVal;
    }

    static int shortUrlToId(String st) {
        if (null == st)
            return -1;

        int id = 0; // initialize result

        char[] arr = st.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                id = id * 62 + (arr[i] - 'a');
            }
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                id = id * 62 + (arr[i] - 'A' + 26);
            }
            if (arr[i] >= '0' && arr[i] <= '9') {
                id = id * 62 + (arr[i] - '0' + 52);
            }

        }
        return id;
    }

    static String reverseString(String string) {
        int i = 0, j = string.length() - 1;
        char[] arr = string.toCharArray();
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        String shorturl = idToShortUrl(n);
        System.out.println("Generated short url is " + shorturl);
        System.out.println("Id from url is " +shortUrlToId(shorturl));
    }
}
