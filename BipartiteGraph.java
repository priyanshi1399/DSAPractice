import java.util.*;
public class BipartiteGraph {

    public static void main(String [] args){
       int  V = 3;
       int [][] edges = {{0, 1}, {1,2}};
        isBipartite(V,edges);
    }

    public static boolean DFS(int curr,HashMap<Integer, List<Integer>> adj,int [] color,int currColor){
        color[curr]=currColor;

        for(int v:adj.getOrDefault(curr,new ArrayList<>())){
            if(color[v]==color[curr]){
                return false;
            }
            if(color[v]==-1){
                int colorV=1-currColor;
                if(DFS(v,adj,color,colorV)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int V, int[][] edges) {
        HashMap<Integer, List<Integer>> adj=new HashMap<>();
        for(int i=0;i<V;i++){
            adj.putIfAbsent(i,new ArrayList<>());
        }

        for(int [] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }
        int [] color=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(DFS(i,adj,color,1)==false){
                    return false;
                }
            }
        }
        return true;

    }


}
