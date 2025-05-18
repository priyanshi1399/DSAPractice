public class FillSpecialGrid {
    private static  int val=0;
    public static void main(String [] args){
        int n=2;
        specialGrid(n);
    }


    public static int[][] specialGrid(int n) {
        int size=1<<n;

        int [][] temp=new int [size][size];
        solve(temp,size,0,0);
        return temp;

    }

    private static void solve(int [][] temp, int size, int row,int col){

        if(size==1){
            temp[row][col]=val++;
            return;
        }

        int s=size/2;

        solve(temp,s,row,col+s); //top-right
        solve(temp,s,row+s,col+s);
        solve(temp,s,row+s,col);
        solve(temp,s,row,col);
    }
}
