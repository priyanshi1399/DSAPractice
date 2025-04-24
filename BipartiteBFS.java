import java.util.*;
public class BipartiteBFS {

    public static void main(String [] args){
        int  V = 3;
        int [][] edges = {{0, 1}, {1,2}};
        isBipartite(V,edges);
    }

    public static boolean isBFSBipartite(int curr,HashMap<Integer, List<Integer>> adj,int [] color,int currColor){

        Queue<Integer> q=new LinkedList<>();
        q.add(curr);
        color[curr]=currColor;
        while(!q.isEmpty()){
            int u=q.peek();
            q.poll();
            for(int v:adj.getOrDefault(u,new ArrayList<>())){
                if(color[v]==color[u]){
                    return false;
                }
                else if(color[v]==-1){
                    color[v]=1-color[u];
                    q.add(v);
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
                if(isBFSBipartite(i,adj,color,1)==false){
                    return false;
                }
            }
        }
        return true;

    }
}
