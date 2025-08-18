public class Word_Search {
    public static void main(String [] args){
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        exist(board,word);
    }

    public static boolean solve(int x,int y, int index, char [][] board, String word){

        if(x>=board.length || y>=board[0].length || x<0 || y<0 || board[x][y]!=word.charAt(index) || board[x][y]=='$'){
            return false;
        }

        if(index==word.length()-1 && board[x][y]==word.charAt(index)){
            return true;
        }

        char temp=board[x][y];
        board[x][y]='$'; //replace with any character

        if(solve(x+1,y,index+1,board,word) || solve(x-1,y,index+1,board,word) || solve(x,y+1,index+1,board,word) || solve(x,y-1,index+1,board,word) ){
            return true;
        }

        board[x][y]=temp;
        return false;
    }
    public static  boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(i,j,0,board,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
