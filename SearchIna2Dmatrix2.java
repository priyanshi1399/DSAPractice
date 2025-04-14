public class SearchIna2Dmatrix2 {

    public static void main(String [] args){
       // int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int [][] matrix = {{1,4},{2,5}};
        int target=2;
        searchMatrix(matrix,target);

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r=0;
        int c=matrix[0].length-1;
        if(matrix==null || matrix.length<1 || matrix[0].length<1){
            return false; //base case
        }

        if(matrix.length==1 && matrix[0].length==1 && target==matrix[0][0]){
            return true; //[[1]]
        }
        while(c>=0 && r<=matrix.length){
            if(target==matrix[r][c]){
                return true;
            }
            else if(target<matrix[r][c]){
                c--;
            }
            else{
                r++;
            }
        }
        return false;

    }
}
