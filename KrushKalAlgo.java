import java.util.*;
public class KrushKalAlgo {


    public static void main(String [] args){
        int V=3;
        int E=3;
        List<List<int []>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
       int [][] temp={{0,1,5},{1,2,3},{0,2,1}};
        for(int [] edge :temp){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            adj.get(u).add(new int[] {v,w});
            adj.get(v).add(new int[] {u,w});
        }

        spanningTree(V,E,adj);

    }

    public static int  find(int x,int [] parent){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x],parent);
    }

    public static void union(int x,int y, int [] parent, int [] rank){
        int x_Parent=find(x,parent);
        int y_Parent=find(y,parent);

        if(x_Parent==y_Parent){
            return;
        }

        else if (rank[x_Parent]> rank[y_Parent]){
            parent[y_Parent]=x_Parent;
        }

        else if (rank[y_Parent]> rank[x_Parent]){
            parent[x_Parent]=y_Parent;
        }
        else{
            parent[y_Parent]=x_Parent;
            rank[x_Parent]++;
        }

    }
    public static int krushkal(List<int[]> edges,int [] parent, int [] rank){
        int sum=0;

        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];

            int parentU=find(u,parent);
            int parentV=find(v,parent);
            if(parentU!=parentV){
                union(u,v,parent,rank);
                sum+=wt;
            }
        }
        return sum;
    }
    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int [] parent=new int[V];
        int [] rank=new int[V];

        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        List<int[]> edges=new ArrayList<>();

        for(int i=0;i<V;i++){
            for(int [] temp: adj.get(i)){
                int u=i;
                int v=temp[0];
                int wt=temp[1];
                edges.add(new int []{u,v,wt});
            }
        }

        edges.sort((a,b)->Integer.compare(a[2],b[2])); //sort according to wt

        return krushkal(edges,parent,rank);
    }
}
