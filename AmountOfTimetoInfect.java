import java.util.*;
public class AmountOfTimetoInfect {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public static void main(String [] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(5);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(9);
        root.left.right.right=new TreeNode(2);
        root.right.left=new TreeNode(10);
        root.right.right=new TreeNode(6);
        int start=3;
        amountOfTime(root,start);
    }

    public static void convert(TreeNode current, int parent,  Map<Integer,List<Integer>>adj){
        if(current==null){
            return;
        }
        if(parent!=-1){
            adj.computeIfAbsent(current.val,k-> new ArrayList<>()).add(parent);
        }
        if(current.left!=null){
            adj.computeIfAbsent(current.val,k->new ArrayList<>()).add(current.left.val);
        }
        if(current.right!=null){
            adj.computeIfAbsent(current.val,k->new ArrayList<>()).add(current.right.val);
        }

        convert(current.left,current.val,adj);
        convert(current.right,current.val,adj);
    }
    public static int amountOfTime(TreeNode root, int start) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        convert(root,-1,adj);
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        q.add(start);
        visited.add(start);
        int minute=0;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-- >0){
                int curr=q.poll();
                for(int ngbr: adj.getOrDefault(curr,Collections.emptyList())){
                    if(!visited.contains(ngbr)){
                        q.add(ngbr);
                        visited.add(ngbr);
                    }
                }
            }
            minute++;
        }
        return minute-1;

    }


}
