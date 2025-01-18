import java.util.*;
public class MergeIntervals {

    public static void main(String [] args){
       int [][] intervals={{2,6},{1,3},{8,10},{15,18}};
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        Stack<int[]> stck=new Stack<>();
        for(int i=0;i<intervals.length;i++){
            if(!stck.isEmpty() && intervals[i][0]<=stck.peek()[1]){
                int val1=stck.peek()[0];
                int val2=stck.peek()[1];
                stck.pop();
                stck.push(new int[] {val1,Math.max(val2,intervals[i][1])});
            }
            else{
                stck.push(new int[] {intervals[i][0],intervals[i][1]});
            }
        }

        int i=0;
        int [][] res=new int[stck.size()][2];
        while(!stck.isEmpty()){
            res[i][0]=stck.peek()[0];
            res[i][1]=stck.peek()[1];
            stck.pop();
            i++;
        }
        return res;
    }
}
