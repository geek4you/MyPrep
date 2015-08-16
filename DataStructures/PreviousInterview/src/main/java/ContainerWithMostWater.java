/**
 * Created by chanumolu on 7/5/15.
 */

/**
 *
 * @link : http://edwardliwashu.blogspot.com/2012/12/container-with-most-water.html
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int capacity = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int water = Math.min(height[left], height[right]) * (right-left);
            if(water > capacity)
                capacity = water;
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return capacity;
    }

}
