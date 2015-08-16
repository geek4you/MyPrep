import java.util.*;

/**
 * Created by chanumolu on 8/2/15.
 */

/*
Given a lot of user logs£¬calculate the user number during time intervals
For example£º
user1:
login_time: 0
logout_time: 1
user2:
login_time: 0
logout_time: 2
user3:
login_time: 1
logout_time: 3
ouput£º
[0 - 2): 2
[2 - 3): 1
[3 - infinite): 0
Note that you don't need output interval 0 -1 because there are two users at point 0 and
two users at point 1. The number of users don't change.

solution: use a map to record the time point and the number of users change. When there is a login, increase the count.
When there is a logout, decrease the count. Print the interval based on the map,
only output the intervals with non zero changes.
O(n) time, O(n) space
*/

class Log {
    int login_time;
    int logout_time;

    public Log(int login_time, int logout_time) {
        this.login_time = login_time;
        this.logout_time = logout_time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "login_time=" + login_time +
                ", logout_time=" + logout_time +
                '}';
    }

}

public class OnlineUsers {

    public static void onlineUsers(List<Log> logs) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for (Log log : logs) {
            int startTIme = log.login_time;
            if (map.containsKey(startTIme)) {
                map.put(startTIme, map.get(startTIme) + 1);
            } else {
                map.put(startTIme, 1);
            }
            int endTime = log.logout_time;
            if (map.containsKey(endTime)) {
                map.put(endTime, map.get(endTime) - 1);
            } else {
                map.put(endTime, -1);
            }
        }

        // we have the difference between usernum of last time and present time in map values.
        // use it to print.
        // work out on paper. Very good trick.
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        Map.Entry<Integer,Integer>  firstEntry = iterator.next();
        int prevTime = firstEntry.getKey();
        int usernum = firstEntry.getValue();

        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            if(entry.getValue()!=0){
                System.out.println("[" + prevTime + " - " +  entry.getKey() +" ) : " + usernum);
                prevTime = entry.getKey();
                usernum += entry.getValue();
            }

        }

        System.out.println("[" + prevTime + " - " +  "infinite ) : " + 0 );
    }

    public static void main(String[] args) {
        List<Log> logs = new ArrayList<Log>();
        logs.add(0,new Log(0,1));
        logs.add(1,new Log(0,2));
        logs.add(2,new Log(1,3));

        onlineUsers(logs);
    }
}
