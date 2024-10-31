public class DistanceBetweenBusStops {

    public  static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int frontSum = 0;
        int backSum = 0;

        for (int i = start; i != destination; i = (i + 1) % distance.length) {
            frontSum += distance[i];
        }
        for (int i = destination; i != start; i = (i + 1) % distance.length) {
            backSum += distance[i];
        }
        return Math.min(frontSum, backSum);
    }

    public static void main(String[] args) {

       int [] distance= {14,13,4,7,10,17,8,3,2,13};

       int start=2;
       int destination=9;
       int k=distanceBetweenBusStops(distance,start,destination);
        System.out.println(k);


    }

}