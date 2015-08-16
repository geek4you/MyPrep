/**
 * Created by chanumolu on 7/30/15.
 */

public class Interval {

    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    }
}
