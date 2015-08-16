import java.util.Arrays;

/**
 * Created by chanumolu on 8/2/15.
 */

/*
There is an non negative integer array. Each number represent the author ID of a post in a forum.
We already know that an author writes more than half of all posts in this forum, find this author ID.

Follow up: suppose that three authors each writes more than 1/4 posts in this forum, find the three authors.

Solution for main: find majority element

 Follow up solution: simiar as above, we delete four different Ids each time, the problem condition remains unchanged.
O(n) time, O(1) space
*/
public class MostPosts {

    public static int[] followUpQuestion(int[] arry) {
        int count1 = 0, count2 = 0, count3 = 0;
        int[] ids = new int[3];
        Arrays.fill(ids, -1);

        for (int i = 0; i < arry.length; i++) {

            if (arry[i] == ids[0]) {
                count1++;
            } else if (arry[i] == ids[1]) {
                count2++;
            }else if(arry[i]==ids[2]){
                count3++;
            }else if(count1==0){
                ids[0]=arry[i];
                count1++;
            }else if(count2==0){
                ids[1]=arry[i];
                count2++;
            }else if (count3==0){
                ids[2]=arry[i];
                count3++;
            }else{
                count1--;
                count2--;
                count3--;
            }
        }

        return ids;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 5, 3, 2, 1};
        int[] res = followUpQuestion(arr1);

        for(int r :res){
            System.out.println(r);
        }


    }
}
