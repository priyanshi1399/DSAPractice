import java.util.*;
public class RatInAMaze {

    public static void main(String [] args) {
        List<List<Integer>> mat = new ArrayList<>();
        mat.add(Arrays.asList(1, 0, 0, 0));
        mat.add(Arrays.asList(1, 1, 0, 1));
        mat.add(Arrays.asList(1, 1, 1, 0));
        mat.add(Arrays.asList(0, 1, 1, 1));
        findPath(mat);

    }

    public static void solve(int i,int j,List<List<Integer>> mat,int n,StringBuilder curr, ArrayList<String> result,boolean [][] visited){

        if(i<0 || j<0 || i>=n || j>=n || mat.get(i).get(j)==0 || visited[i][j]==true){
            return;
        }
        if(i ==n-1 && j==n-1){
            result.add(curr.toString());
            return;
        }

        visited[i][j]=true;

        curr=curr.append('L');
        solve(i,j-1,mat,n,curr,result,visited);
        curr.deleteCharAt(curr.length()-1);

        curr=curr.append('R');
        solve(i,j+1,mat,n,curr,result,visited);
        curr.deleteCharAt(curr.length()-1);

        curr=curr.append('U');
        solve(i-1,j,mat,n,curr,result,visited);
        curr.deleteCharAt(curr.length()-1);

        curr=curr.append('D');
        solve(i+1,j,mat,n,curr,result,visited);
        curr.deleteCharAt(curr.length()-1);

        visited[i][j]=false;


    }
    // Function to find all possible paths
    public static ArrayList<String> findPath(List<List<Integer>> mat) {
        int n=mat.size();
        ArrayList<String> result=new ArrayList<>();
        StringBuilder curr=new StringBuilder();
        boolean [][]  visited=new boolean[n][n];
                    solve(0,0,mat,n,curr,result,visited);

        return result;
    }
}
