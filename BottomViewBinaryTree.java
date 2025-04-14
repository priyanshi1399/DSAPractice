import java.util.*;
public class BottomViewBinaryTree {

    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        public static void main(String [] args){
        //1 null -2 91 null null null
            TreeNode root=new TreeNode(1);
            root.right=new TreeNode(-2);
            root.right.left=new TreeNode(91);
            bottomView(root);
        }

        public  static List<Integer> bottomView(TreeNode root) {
            List<Integer> result=new ArrayList<>();
            Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
            TreeMap<Integer,Integer> map=new TreeMap<>();
            q.add(new Pair<>(root,0));
            while(!q.isEmpty()){
                Pair<TreeNode,Integer> pair=q.poll();
                TreeNode node=pair.getKey();
                int line=pair.getValue();


                    map.put(line,node.val);



                if(node.left!=null){
                    q.add(new Pair<>(node.left,line-1));
                }

                if(node.right!=null){
                    q.add(new Pair<>(node.right,line+1));
                }
            }

            for(int value: map.values()){
                result.add(value);
            }
            return result;

        }
        public static class Pair<F,S>{
            private final F First;
            private final S Second;

            Pair(F first,S second){
                this.First=first;
                this.Second=second;
            }

            public F getKey(){
                return First;
            }

            public S getValue(){
                return Second;
            }
        }
    }


