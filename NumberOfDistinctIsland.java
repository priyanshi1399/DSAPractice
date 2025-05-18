import java.util.*;
public class NumberOfDistinctIsland {

    private static int m;
    private static int n;
    private  static final int [][] directions={{0,1}, {0,-1},{1,0},{-1,0}};

    public static void main(String [] args){
        int [][] grid={{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1},{1, 1, 0, 1, 1}};
        countDistinctIslands(grid);
    }
    public static boolean isSafe(int i,int j){
        if(i>=0 && j>=0 && i<m && j<n){
            return true;
        }
        return false;
    }


    public static void DFS(int [][] grid,int row,int col, boolean [][] visited,List<String> path, int rowBase, int colBase){

        path.add((row-rowBase) + "," + (col-colBase));

        for(int [] dir: directions){
            int newRow=row+dir[0];
            int newCol=col+dir[1];

            if((isSafe(newRow,newCol)) && (!visited[newRow][newCol]) && (grid[newRow][newCol]==1)){
                visited[newRow][newCol]=true;


                DFS(grid,newRow,newCol,visited,path,rowBase,colBase);
            }
        }
    }
    public static int countDistinctIslands(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean [][] visited=new boolean[m][n];
        Set<List<String>> st=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    visited[i][j]=true;
                    List<String> path=new ArrayList<>();
                    DFS(grid,i,j,visited,path,i,j);

                    st.add(path);

                }
            }
        }

        return st.size();
    }
}
