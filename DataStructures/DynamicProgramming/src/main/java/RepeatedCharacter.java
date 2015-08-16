/**
 * Created by Pradeep on 5/20/15.
 */
public class RepeatedCharacter {

    public static void findRepeated(String str)
    {
        char[] c=str.toCharArray();
        char temp=c[0];
        char repeat=c[0];
        int max_so_far=1;
        int start_point=0;
        int max_ending_here=1;

        for(int i=1;i<c.length;i++)
        {
            if(c[i]==temp)
            {
                max_ending_here++;
            }
            else
            {
                max_ending_here=0;
                temp=c[i];
                start_point=i;
            }
            if(max_ending_here>max_so_far)
            {
                max_so_far=max_ending_here;
                repeat=temp;
            }
        }
        System.out.println("Starting Position:"+start_point+" Repeat Times:"+max_so_far+"\n");
        for(int i=0;i<=max_so_far;i++)
            System.out.print(repeat);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str="priyyyyyaaaanshuuuujhaaah";
        findRepeated(str);

    }

}