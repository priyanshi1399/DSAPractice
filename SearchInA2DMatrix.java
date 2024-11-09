public class SearchInA2DMatrix {


    public static void main(String [] args){
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=13;
        searchmatrix(matrix,target);

    }

    public static boolean binarySearch(int [] row, int target ){
        int l=0;
        int h=row.length-1;

        while(l<=h){
            int mid=l+(h-l)/2;

            if(row[mid]<target){
                l=mid+1;
            }
            else if(row[mid]==target){
                return true;
            }
            else{
                h=mid-1;
            }
        }
        return false;

    }

    public static boolean searchmatrix(int[][] matrix, int target ){
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++){
        if(matrix[i][0]<=target && target<=matrix[i][n-1]){
            if(binarySearch(matrix[i],target)){
                return true;
            }
        }
    }
        return false;
}
}
//T(C)-0(n)+log m