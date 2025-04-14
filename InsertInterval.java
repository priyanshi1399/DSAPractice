import  java.util.*;

public class InsertInterval {

    public static void main(String [] args){
      int [][]  intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
      int [] newInterval = {4,8};
      insert(intervals,newInterval);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> result=new ArrayList<>();
        int j=0;
        for(int [] i: intervals){
            if(result.isEmpty() || result.get(result.size()-1)[1]<i[0]){
                result.add(i);
            }
            if(!result.isEmpty() && j<2 && result.get(result.size()-1)[1]>=newInterval[j]){
                result.get(result.size()-1)[0]=Math.min(result.get(result.size()-1)[0],newInterval[j]);
                j++;
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1],newInterval[j]);
                j++;

            }
            if(!result.isEmpty() && j<2 && result.get(result.size()-1)[1]<newInterval[j]){
                result.add(newInterval);

            }
            if(!result.isEmpty() && result.get(result.size()-1)[1]>=i[0]){
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1],i[1]);
            }
        }
        if(result.isEmpty()){

            return new int[][]{{newInterval[0],newInterval[1]}};
        }
        int [][] ans=new int[result.size()][2];

        for(int i=0;i<result.size();i++){
            ans[i][0]=result.get(i)[0];
            ans[i][1]=result.get(i)[1];
        }
        return ans;

    }
}

