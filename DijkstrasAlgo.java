import java.util.*;
public class DijkstrasAlgo {


    public static void main(String [] args){
        int V=3;
        int [][] edges={{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        int src=2;
        dijkstra(V,edges,src);
    }

    public  static int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        //making adjacencyList

        for(int [] edge: edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int [] {u,w});

        }

        int [] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src]=0;

        PriorityQueue<int [] > pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        pq.add(new int[]{0,src});
        while(!pq.isEmpty()){

            int [] curr=pq.poll();
            int d=curr[0];
            int node=curr[1];



            for(int [] neighbor: adj.get(node)){
                int v=neighbor[0];
                int weight=neighbor[1];

                if(d+weight<dist[v]){
                    dist[v]=d+weight;
                    pq.add(new int[]{dist[v],v});
                }
            }
        }
        return dist;

    }
}
