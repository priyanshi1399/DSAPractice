import java.util.*;
public class NonOverlappingIntervals {


    public static void main(String [] args){
        int [][] intervals={{1,100},{11,22},{1,11},{2,12}};
        eraseOverlapIntervals(intervals);
    }

    public  static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        Stack<int[]> stck=new Stack<>();
        int count=0;
        for(int i=0;i<intervals.length;i++){
            if(!stck.isEmpty() && stck.peek()[1]<=intervals[i][0]){
                int value1=stck.peek()[0];
                int value2=stck.peek()[1];
                stck.pop();
                stck.push(new int[]{value1,Math.max(value2,intervals[i][1])});
            }
            else if(!stck.isEmpty() && stck.peek()[1]>=intervals[i][0]){
                count++;
            }
            else{
                stck.push(new int []{intervals[i][0], intervals[i][1]});
            }
        }
        return count;
    }
}
