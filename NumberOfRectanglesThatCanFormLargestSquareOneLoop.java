public class NumberOfRectanglesThatCanFormLargestSquareOneLoop {

    public static int countGoodRectangles(int[][] rectangles) {
        int count=0;
        int maxLength = 0;
        int n = rectangles.length;
        for (int i = 0; i < n; i++) {
            int maxSideOfSquare=Math.min(rectangles[i][0],rectangles[i][1]);
            if(maxLength<maxSideOfSquare){
                maxLength=maxSideOfSquare;
                count=1;
            }
            else if(maxLength==maxSideOfSquare) {
                count++;
            }
        }
        return count;
    }

    public static void main(String [] args){
        //int [][] rectangles={{3,2},{5,6},{2,3},{5,7},{8,9},{8,10}};
        int [][] rectangles= {{5,8},{3,9},{5,12},{16,5}};
        int val=countGoodRectangles(rectangles);
        System.out.println(val);
    }
}

