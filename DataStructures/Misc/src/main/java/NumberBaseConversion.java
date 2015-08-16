/**
 * Created by Pradeep on 5/11/15.
 */

/**
 * Number Base Conversion: The example below converts a given base 10 number to base 8. (The same technique will work for conversions to any desired base.)
 n = 93.  Repeatedly divide by 8 and take the remainder.
 Then repeat with the quotient by 8. Stop at 0 quotient.

 93%8 == 5 (remainder) and 93/8 == 11 (quotient)
 11%8 == 3 (remainder) and 11/8 ==  1 (quotient)
 1%8 == 1 (remainder) and  1/8 ==  0 (quotient)
 The numbers in red boldface (the remainders) are the base 8 digits of 93, generated backwards (least significant digit first). We want to write them forwards, to get 135 (base 8), and for this purpose, we can push them on a stack, and pop them off, as in the following code:

 public void writebase(int n) {
  while (n > 0) {
    push(n%8);
    n = n/8;
  }
  while (!empty())
   System.out.print(pop());
 }


 */


// link: http://www.cs.utsa.edu/~wagner/CS3343/recursion/bases.html
public class NumberBaseConversion {

}


// BaseConvert: convert to base 8 using stack
class BaseConvert {
    public int[] s = new int[100]; // storage for stack
    public int top = 0; // points one above top
    public int pop() { return s[--top]; }//pop, return top
    public void push(int n) { s[top++] = n; } // push item
    public boolean empty() { return top == 0; } // empty?

    public void writebase(int n) {
        while (n > 0) {
            push(n%8);
            n = n/8;
        }
        while (!empty())
            System.out.print(pop());
    }

    public static void main(String[] args) {
        int n = 93;
        BaseConvert baseConvert = new BaseConvert();
        baseConvert.writebase(n);
        System.out.println(" is the value of " +
                n + " (base 8)");
    }
}

// BaseConversion.java: convert to base 8 (recursion. without using stack)

class BaseConversion {

    public void writebase(int n) {
        System.out.println("Enter writebase, n = " + n);
        if (n != 0) {
            writebase(n / 8);
            System.out.println("Printing: " + n % 8);
        }
        System.out.println("Leave writebase, n = " + n);
    }
}