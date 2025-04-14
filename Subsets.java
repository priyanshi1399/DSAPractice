import java.sql.SQLOutput;
import java.util.*;
public class Subsets {

    public static void main(String [] args){
        List<List<Integer>> res =new ArrayList<>();
        int  [] nums = {1,2,3};
        res=subsets(nums);
       for(List<Integer> innereList: res){
           for(Integer element: innereList ){
               System.out.println(element);
           }

        }

    }

    public static  void formAllSubsequence(int ind, int [] nums, int n,List<Integer> current ,List<List<Integer>> ans){

        if(ind==n){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[ind]);
        formAllSubsequence(ind+1,nums,n,current,ans);
        current.remove(current.size()-1); //because after backtracking we have to remove that list then check again

        formAllSubsequence(ind+1,nums,n,current,ans);
    }

    public static  List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>(); //geneerated all subsequence it will store
        List<Integer> current = new ArrayList<>(); //temporary or current List to store subsequences

        formAllSubsequence(0,nums,n,current,ans);
        return ans;

    }
}
