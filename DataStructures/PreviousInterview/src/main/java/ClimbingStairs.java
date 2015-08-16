/**
 * Created by chanumolu on 7/5/15.
 */

/**
 *
 Climbing Stairs

 You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Approach: Actually, this is the Fibonacci Number:
 Fn = Fn-1 + Fn-2
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int s0 = 0;
        int s1 = 1;
        int result = 0;
        for(int i = 0; i < n; i++){
            result = s0 + s1;
            s0 = s1;
            s1 = result;
        }

        return result;
    }
}
