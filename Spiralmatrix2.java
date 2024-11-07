public class Spiralmatrix2 {

    public static  void main(String [] args){
        int n=3;
        generateMatrix(n);
    }

    public static int[][] generateMatrix(int n) {
        int [][] matrix=new int [n][n];
        int count=1;
        int left=0;
        int right=n-1;
        int bottom=n-1;
        int top=0;
        while(count<=n*n){
            for(int i=left;i<=right && count<=n*n;i++){
                matrix[top][i]=count++;
            }
            top++;
            for(int i=top;i<=bottom && count<=n*n;i++){
                matrix[i][right]=count++;
            }
            right--;
            for(int i=right;i>=left && count<=n*n;i--){
                matrix[bottom][i]=count++;
            }
            bottom--;
            for(int i=bottom;i>=top && count<=n*n;i--){
                matrix[i][left]=count++;
            }
            left++;
        }
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[i].length;j++){
        //         matrix[i][j]=
        //     }
        return matrix;
    }
}
