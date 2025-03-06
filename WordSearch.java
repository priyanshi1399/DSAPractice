public class WordSearch {
public static void main(String [] args){

    char [] [] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

    String word = "ABCCED";
    exist(board,word);
}
    public static boolean solve(char [][] board,String word, boolean [][] visited,int index,int i,int j,int m,int n){
        if(index==word.length()){
            return true;
        }

        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || board[i][j]!=word.charAt(index)){
            return false;
        }

        visited[i][j]=true;
        if(solve(board,word,visited,index+1,i+1,j,m,n) ||  solve(board,word,visited,index+1,i-1,j,m,n) ||
                solve(board,word,visited,index+1,i,j+1,m,n) ||  solve(board,word,visited,index+1,i,j-1,m,n) ){
            return true;
        }

        visited[i][j]=false;

        return false;
    }
    public  static boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;

        boolean [][] visited=new boolean[m][n];
        boolean result=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    result=solve(board,word,visited,0,i,j,m,n);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
