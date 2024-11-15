public class NumberOfRectanglesThatCanFormLargestSquare {

    public static int countGoodRectangles(int[][] rectangles){
    int maxLength=0;
        int n=rectangles.length;
        for(int i=0;i<n;i++){
           int maxSideOfSquare=Math.min(rectangles[i][0],rectangles[i][1]);
            maxLength=Math.max(maxLength,maxSideOfSquare);
        }
        int count=0;
        for(int i=0;i<n;i++){
            int maxSideOfSquare=Math.min(rectangles[i][0],rectangles[i][1]);
            if(maxLength==maxSideOfSquare){
                count++;
            }
        }
        return count;
    }


    public static void main(String [] args){
        int [][] rectangles={{5,8},{3,9},{5,12},{16,5}};
        int val=countGoodRectangles(rectangles);
        System.out.println(val);
    }
}
