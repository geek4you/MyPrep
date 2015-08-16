package Stacks;

import java.util.Stack;

/**
 * Created by Pradeep on 5/7/15.
 */

public class MinElementInStack {

    public static int minEle(Stack<Integer> stack){
        return minEleUtil(stack,Integer.MAX_VALUE);
    }

    public static int minEleUtil(Stack<Integer> stack,int min){
        if(stack.empty()){
            return min;
        }

        int pop = stack.pop();
        if(min>pop){
            min = pop;
        }

        int returnval =  minEleUtil(stack,min);
        stack.push(pop);
        return returnval;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(10);
        stack.push(30);
        stack.push(1);
        stack.push(20);

        System.out.println(minEle(stack));
        System.out.println("stack:");
        for(Integer st : stack){
            System.out.println(st);
        }

    }
}
