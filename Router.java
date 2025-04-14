import java.util.*;
public class Router {
    public static void main(String[] args) {
        Router router = new Router(3); // Step 0

        // Step 1
        System.out.println(router.addPacket(1, 4, 90)); // true

        // Step 2
        System.out.println(router.addPacket(2, 5, 90)); // true

        // Step 3
        System.out.println(router.addPacket(1, 4, 90)); // false (duplicate)

        // Step 4
        System.out.println(router.addPacket(3, 5, 95)); // true

        // Step 5
        System.out.println(router.addPacket(4, 5, 105)); // true (evicts first packet)

        // Step 6
        System.out.println(Arrays.toString(router.forwardPacket())); // [2, 5, 90]

        // Step 7
        System.out.println(router.addPacket(5, 2, 110)); // true

        // Step 8
        System.out.println(router.getCount(5, 100, 110)); // 1
    }

    private static int size;
    private static HashSet<ArrayList<Integer>> hs = new HashSet<>();
    private static Queue<ArrayList<Integer>> q = new LinkedList<>();
    private static HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
    public Router(int m) {
        size=m;
    }

    public static boolean addPacket(int s, int d, int r) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(s,d,r));
        if(hs.contains(arr)) return false;
        if(q.size()==size){
            int val = q.peek().get(1);
            hs.remove(q.remove());
            ArrayList<Integer> tm = hm.get(val);
            tm.remove(0);
        }
        q.add(arr);
        hs.add(arr);
        if(!hm.containsKey(d)) hm.put(d,new ArrayList<>());
        ArrayList<Integer> tm = hm.get(d);
        tm.add(r);
        return true;
    }

    public static int[] forwardPacket() {
        if(q.isEmpty()) return new int[]{};
        ArrayList<Integer> arr = q.remove();
        hs.remove(arr);
        int s = arr.get(1),r = arr.get(2);
        ArrayList<Integer> tm = hm.get(s);
        tm.remove(0);
        if(hm.get(s).size()==0) hm.remove(s);
        return new int[]{arr.get(0),arr.get(1),arr.get(2)};
    }

    public static int countInRange(ArrayList<Integer> arr, int s, int e) {
        int left = lowerBound(arr, s);
        int right = upperBound(arr, e);
        return right - left;
    }

    public static int lowerBound(ArrayList<Integer> arr, int target) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(ArrayList<Integer> arr, int target) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static int getCount(int d, int s, int e) {
        if(!hm.containsKey(d)){
            return 0;
        }
        return countInRange(hm.get(d),s,e);
    }
}

