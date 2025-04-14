import java.util.*;
public class combinationsum2 {

    public static void main(String [] args){
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        combinationSum2(candidates,target);
    }

    public static  void backtrack(int [] candidates, int target, List<List<Integer>> ans, List<Integer> temp,int startIndex){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(target<0){
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(candidates,target-candidates[i],ans,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(candidates,target,ans,new ArrayList<>(),0);
        return ans;
    }
}

