public class surroundedRegions {

    public static void main(String [] args){
    char [][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
    solve(board);
    }
    
    static int m;
    static int n;
    private static int [][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean isSafe(int x,int y){
        if(x>=0 && y>=0 && x<m && y<n){
            return true;
        }
        return false;
    }
    public static void dfs(int i,int j,char [][] board, boolean [][] vis){
        vis[i][j]=true;

        for(int [] dir: directions){
            int i_=i+dir[0];
            int j_=j+dir[1];

            if(isSafe(i_,j_) && !vis[i_][j_] && board[i_][j_]=='O'){
                dfs(i_,j_,board,vis);
            }
        }
    }
    public static void solve(char[][] board) {
        m=board.length;
        n=board[0].length;
        boolean [][] vis=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && (board[i][j]=='O') && (!vis[i][j])){
                    dfs(i,j,board,vis);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}
