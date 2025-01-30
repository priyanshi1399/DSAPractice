public class DiagonalTraverse {

    public static void main(String [] args){
        int [][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        findDiagonalOrder(mat);
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        int [] result =new int[rows*cols];
        int i=0;int j=0;
        for(int k=0;k<rows*cols;k++){
            result[k]=mat[i][j];
            if((i+j)%2==0){
                //Upward direction
                //i-1,j+1 //from 7 to 5
                //j+1 //2
                //i+1  //7
                //these were the possible option
                if(i-1>=0 &&  j+1<cols){
                    i--;
                    j++;
                }
                else if(j+1<cols){
                    j++;
                }
                else{
                    i++;
                }
            }
            else{
                //Downward Direction
                //i+1 j-1
                //i+1
                //j+1
                if(i+1<rows && j-1>=0){
                    i++;
                    j--;
                }
                else if(i+1<rows){
                    i++;
                }
                else{
                    j++;
                }
            }
        }
        return result;
    }
}
