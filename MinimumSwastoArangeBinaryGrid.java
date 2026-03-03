public class MinimumSwastoArangeBinaryGrid {


    public static void main(String[] args) {
    //[[0,0,1],[1,1,0],[1,0,0]]
        int [][] grid={{0,0,1},{1,1,0},{1,0,0}};

        int ans= minSwaps(grid);
        System.out.println(ans);

    }
    public static int minSwaps(int[][] grid) {
        int n=grid.length;
        int [] endZeroes=new int [n];
        //count no of zeroes
        for(int i=0;i<n;i++){
            int j=n-1;
            int count=0;
            while(j>=0 && grid[i][j]==0){
                j--;
                count++;
            }

            endZeroes[i]=count;
        }
        int swaps=0;

        for(int i=0;i<n;i++){
            int need=n-i-1;
            int j=i; //starting from same

            while(j<n && endZeroes[j]<need){
                j++;
            }
            if(j==n){
                return -1;
            }
            swaps+=j-i;
            while(j>i){
                int temp=endZeroes[j];
                endZeroes[j]=endZeroes[j-1];
                endZeroes[j-1]=temp;
                j--;
            }

        }
        return swaps;
    }
}
