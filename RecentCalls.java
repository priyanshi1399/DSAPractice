import java.util.*;
    public class RecentCalls {

        Queue<Integer> q;

        public RecentCalls() {
            q = new LinkedList<>();

        }

        public int ping(int t) {
            q.add(t);
            while (!q.isEmpty() && q.peek() < t - 3000) {
                q.poll();
            }
            return q.size();
        }

        public static void main(String[] args) {
            RecentCalls obj = new RecentCalls();
            System.out.println(obj.ping(1));
            System.out.println(obj.ping(100));
            System.out.println(obj.ping(3001));
            System.out.println(obj.ping(3002));

        }
    }

