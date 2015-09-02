/**
 * Created by chanumolu on 8/19/15.
 */

/**
 * Check if a given sequence of moves for a robot is circular or not
 * Given a sequence of moves for a robot, check if the sequence is circular or not. A sequence of moves is circular if
 * first and last positions of robot are same. A move can be on of the following.
 * <p>
 * G - Go one unit
 * L - Turn left
 * R - Turn right
 * <p>
 * Examples:
 * <p>
 * Input: path[] = "GLGLGLG"
 * Output: Given sequence of moves is circular
 * <p>
 * Input: path[] = "GLLG"
 * Output: Given sequence of moves is circular
 * We strongly recommend to minimize your browser and try this yourself first.
 * <p>
 * The idea is to consider the starting position as (0, 0) and direction as East (We can pick any values for these).
 * If after the given sequence of moves, we come back to (0, 0), then given sequence is circular, otherwise not.
 * <p>
 * N
 * |
 * |
 * W -------------- E
 * |
 * |
 * S
 * The move ‘G’ changes either x or y according to following rules.
 * a) If current direction is North, then ‘G’ increments y and doesn’t change x.
 * b) If current direction is East, then ‘G’ increments x and doesn’t change y.
 * c) If current direction is South, then ‘G’ decrements y and doesn’t change x.
 * d) If current direction is West, then ‘G’ decrements x and doesn’t change y.
 * <p>
 * The moves ‘L’ and ‘R’, do not change x and y coordinates, they only change direction according to following rule.
 * a) If current direction is North, then ‘L’ changes direction to West and ‘R’ changes to East
 * b) If current direction is East, then ‘L’ changes direction to North and ‘R’ changes to South
 * c) If current direction is South, then ‘L’ changes direction to East and ‘R’ changes to West
 * d) If current direction is West, then ‘L’ changes direction to South and ‘R’ changes to North.
 */
public class SequenceOfMovesOfRobotCircularOrNot {

    public static boolean isCircular(char[] moves) {

        int x = 0;
        int y = 0;
        char facing = 'E';

        for (char c : moves) {
            switch (c) {
                case 'L':
                    if (facing == 'E')
                        facing = 'N';
                    else if (facing == 'N')
                        facing = 'W';
                    else if (facing == 'W')
                        facing = 'S';
                    else if (facing == 'S')
                        facing = 'E';

                    break;

                case 'R':
                    if (facing == 'E')
                        facing = 'S';
                    else if (facing == 'N')
                        facing = 'E';
                    else if (facing == 'W')
                        facing = 'N';
                    else if (facing == 'S')
                        facing = 'W';

                    break;

                case 'G':
                    if (facing == 'E')
                        x = x + 1;
                    else if (facing == 'W')
                        x = x - 1;
                    else if (facing == 'N')
                        y = y + 1;
                    else if (facing == 'S')
                        y = y - 1;
                    break;
            }

            System.out.println("x , y after move " + c + " : (x,y) => (" + x + " , " + y + " ) , facing : "+facing);
        }

        if (x == 0 && y == 0)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        char path[] = {'G', 'L', 'G', 'L', 'G', 'L', 'G'};

        System.out.println(isCircular(path));
    }

}
