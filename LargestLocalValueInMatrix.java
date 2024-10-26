public class LargestLocalValueInMatrix {
    public static int findMaxElement(int [][] grid,int row, int col){
        int maxVal=Integer.MIN_VALUE;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                maxVal=Math.max(maxVal,grid[i][j]);
            }
        }
        return maxVal;
    }


    public static int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int [][] maxLocal=new int[n-2][n-2];
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                maxLocal[i][j]=findMaxElement(grid,i,j);
            }
        }
        return maxLocal;
    }

    public static void main(String [] args){
        int [][]grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int [][] newArray=largestLocal(grid);
        for(int i=0;i< newArray.length;i++){
            for(int j=0;j< newArray[i].length;j++){
                System.out.print(newArray[i][j]);
            }
            System.out.println();
        }
    }
}
