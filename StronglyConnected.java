import java.util.*;
public class StronglyConnected {

    public static  void main(String [] args){
        List<List<Integer>> adj=Arrays.asList(Arrays.asList(2,3),
                Arrays.asList(0),
                Arrays.asList(1),
                Arrays.asList(4),
                new ArrayList<>());

        kosaraju(adj);

    }


    public static  void DFS(ArrayList<ArrayList<Integer>> reverseAdj,boolean [] visited,int u){
        visited[u]=true;

        for(int v:reverseAdj.get(u)){
            if(!visited[v]){
                DFS(reverseAdj,visited,v);
            }
        }
    }
    public static void DFSFill(int u,List<List<Integer>> adj, boolean [] visited, Stack<Integer> stck ){
        visited[u]=true;

        for(int v: adj.get(u)){
            if(!visited[v]){
                DFSFill(v,adj,visited,stck);
            }
        }
        stck.push(u);
    }
    // Function to find number of strongly connected components in the graph.
    public static int kosaraju(List<List<Integer>> adj) {
        int V=adj.size();
        Stack<Integer> stck=new Stack<>();

        boolean[] visited=new boolean[V];

        for(int u=0;u<V;u++){
            if(!visited[u]){
                DFSFill(u,adj,visited,stck);
            }
        }

        //make reverse graph
        ArrayList<ArrayList<Integer>> reverseAdj=new ArrayList<>();
        for(int i=0;i<V;i++){
            reverseAdj.add(new ArrayList<>());
        }
        for( int u=0;u<V;u++){
            for(int v: adj.get(u)){
                reverseAdj.get(v).add(u);
            }
        }

        Arrays.fill(visited,false);

        int count=0;
        while(!stck.isEmpty()){
            int u=stck.peek();
            stck.pop();
            if(!visited[u]){
                DFS(reverseAdj,visited,u);
                count++;
            }
        }
        return count;

    }
}
