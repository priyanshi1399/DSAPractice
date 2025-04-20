import java.util.*;
public class CycleDetectionInDirectedGraph {

    public static void main(String[] args) {
        int V = 3; // Number of vertices
        int E=2;
        // Edge list input (1-based indexing from problem)
        int[][] mp = {
                {0,1},
                {2,1}

        };

        CycleDetectionInDirectedGraph sol = new CycleDetectionInDirectedGraph();
        boolean result = sol.isCyclic(V, mp);
        System.out.println(result);  // Expected Output: false
    }

    public static boolean isCycleDFS(int u,ArrayList<ArrayList<Integer>> adj,boolean [] visited, boolean [] inRecursion, int V ){
        visited[u]=true;
        inRecursion[u]=true;

        for(int v:adj.get(u)){
            if(!visited[v] && isCycleDFS(v,adj,visited,inRecursion,V)){
                return true;
            }
            else if(inRecursion[v]==true){
                return true; //there is a cycle
            }

        }
        inRecursion[u]=false;
        return false;
    }
    public  static boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }

        boolean [] visited=new boolean[V];
        boolean [] inRecusrion=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && isCycleDFS(i,adj,visited,inRecusrion,V)){
                return true;
            }
        }
        return false;

    }
}
