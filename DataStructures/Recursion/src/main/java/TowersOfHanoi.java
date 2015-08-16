/**
 * Created by Pradeep on 6/9/15.
 */
public class TowersOfHanoi {

    // recursive
    public static void toh1(int n, String sourceTower, String destTower, String auxiliaryTower) {

        // Base case (termination condition)
        if (0 == n)
            return;

        // Move first n-1 disks from source pole
        // to auxiliary pole using destination as
        // temporary pole
        toh1(n - 1, sourceTower, auxiliaryTower, destTower);

        // Move the remaining disk from source
        // pole to destination pole
        System.out.println("Move the disk " + n + " from " + sourceTower + " to " + destTower);

        // Move the n-1 disks from auxiliary (now source)
        // pole to destination pole using source pole as
        // temporary (auxiliary) pole
        toh1(n - 1, auxiliaryTower, destTower, sourceTower);
    }


    public static void main(String[] args) {
        toh1(5,"S","D","A");
    }
}
