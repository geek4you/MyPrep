/**
 * Created by Pradeep on 5/20/15.
 */
public class SnakeSequence {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] grid = { { 1, 3, 2, 6 }, { -9, 7, 1, -1 }, { 1, 5, 0, 1 },
                { 4, 7, 1, 3 } };
        constructSequence(grid);

    }

    public static void constructSequence(int[][] grid) {
        int[][] dp = new int[4][4];
        int max=0;
        int maxx=0,maxy=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = 1;
                if (j > 0) {
                    if (Math.abs(grid[i][j] - grid[i][j - 1]) == 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
                if (i > 0) {
                    if (Math.abs(grid[i][j] - grid[i - 1][j]) == 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + 1);
                    }
                }
                if(dp[i][j]>max)
                {
                    max=dp[i][j];
                    maxx=i;
                    maxy=j;
                }
            }
        }
        reconstruct(grid,dp,max,maxx,maxy);
    }
    public static void reconstruct(int[][]grid,int[][]dp,int max,int maxx,int maxy)
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
                System.out.print(grid[i][j]+"\t");
            System.out.println();
        }
        System.out.println("-----DP----");
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        while(max!=0)
        {
            System.out.print(grid[maxx][maxy]+" ");
            max--;
            if(maxx>0)
            {
                if(Math.abs(dp[maxx-1][maxy]-dp[maxx][maxy])==1)
                    maxx--;
                else
                    maxy--;
            }else
                maxy--;

        }
    }

}
