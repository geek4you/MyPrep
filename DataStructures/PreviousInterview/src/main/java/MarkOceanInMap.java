/**
 * Created by chanumolu on 11/7/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 To execute Java, please define "static void main" on a class named Solution.

 If you need more classes, simply define them inline.

 Given: An array of strings where "L" indicates land and "W" indicates water, and a coordinate marking a starting point
 in the middle of the ocean

 The Challenge: Find and mark the ocean in the map by changing appropriate W's to O's. An ocean coordinate is defined
 to be any coordinate directly adjacent to any other ocean coordinate.

 Input:
 LLLLLLLLLLLLLLLLLLLL
 LLLLLLLLLLLLLLWLLLLL
 LLWWLLLLLLLLLLLLLLLL
 LLWWLLLLLLLLLLLLLLLL
 LLLLLLLLLLLLLLLLLLLL
 LLLLLLLWWLLLLLLLLLLL
 LLLLLLLLWWLLLLLLLLLL
 LLLLLLLLLWWWLLLLLLLL
 LLLLLLLLLLWWWWWWLLLL
 LLLLLLLLLLWWWWWWLLLL
 LLLLLLLLLLWWWWWWLLLL
 LLLLWWLLLLWWWWWWLLLL
 LLLLWWWLLLWWWWWWWWWW
 LLLLLWWWWWWWWWWWLLLL
 LLLLLLLLLLLLLLWWWWLL
 LLLLLLLLLLLLLLWLLLLL
 LLLLWLLLLLLLLLLLLWLL
 LLLLLLLLLLLLLLLLLLWL

 Ocean Coordinate:
 row = 10
 col = 12

 Expected Output:
 LLLLLLLLLLLLLLLLLLLL
 LLLLLLLLLLLLLLWLLLLL
 LLWWLLLLLLLLLLLLLLLL
 LLWWLLLLLLLLLLLLLLLL
 LLLLLLLLLLLLLLLLLLLL
 LLLLLLLOOLLLLLLLLLLL
 LLLLLLLLOOLLLLLLLLLL
 LLLLLLLLLOOOLLLLLLLL
 LLLLLLLLLLOOOOOOLLLL
 LLLLLLLLLLOOOOOOLLLL
 LLLLLLLLLLOOOOOOLLLL
 LLLLOOLLLLOOOOOOLLLL
 LLLLOOOLLLOOOOOOOOOO
 LLLLLOOOOOOOOOOOLLLL
 LLLLLLLLLLLLLLOOOOLL
 LLLLLLLLLLLLLLOLLLLL
 LLLLWLLLLLLLLLLLLWLL
 LLLLLLLLLLLLLLLLLLWL
 */


public class MarkOceanInMap {



    public static void main(String[] args) {
        List<String> points = new ArrayList<String>();
        String s = "LLLLLLLLLLLLLLLLLLLL";
        points.add("LLLLLLLLLLLLLLLLLLLL");
        points.add("LLLLLLLLLLLLLLWLLLLL");
        points.add("LLWWLLLLLLLLLLLLLLLL");
        points.add("LLWWLLLLLLLLLLLLLLLL");
        points.add("LLLLLLLLLLLLLLLLLLLL");
        points.add("LLLLLLLWWLLLLLLLLLLL");
        points.add("LLLLLLLLWWLLLLLLLLLL");
        points.add("LLLLLLLLLWWWLLLLLLLL");
        points.add("LLLLLLLLLLWWWWWWLLLL");
        points.add("LLLLLLLLLLWWWWWWLLLL");
        points.add("LLLLLLLLLLWWWWWWLLLL");
        points.add("LLLLWWLLLLWWWWWWLLLL");
        points.add("LLLLWWWLLLWWWWWWWWWW");
        points.add("LLLLLWWWWWWWWWWWLLLL");
        points.add("LLLLLLLLLLLLLLWWWWLL");
        points.add("LLLLLLLLLLLLLLWLLLLL");
        points.add("LLLLWLLLLLLLLLLLLWLL");
        points.add("LLLLLLLLLLLLLLLLLLWL");


        // printOcean(points, s.length(), 10, 12);

    }
}
