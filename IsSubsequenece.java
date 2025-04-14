import java.util.*;
public class IsSubsequenece {
    public static void main(String [] args){
        String s="acb";
        String t="ahbgdc";
        isSubsequence(s,t);
    }

    public static boolean isSubsequence(String s, String t) {
        HashMap<Character,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.putIfAbsent(t.charAt(i),new ArrayList<>());
            map.get(t.charAt(i)).add(i);
        }
        int prev=-1;
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){ //if that charcater is not present
                return false;
            }

            List<Integer> indices=map.get(s.charAt(i));
            System.out.println("Size of teh List is" +indices.size());
            //int index= UpperBound(indices,prev);
            int index=Collections.binarySearch(indices,prev+1);
            System.out.println("index is"+index);

            if(index<0){
                index=-index-1;
            }
            if(index==indices.size()){
                return false; //means we have not found
            }

            prev=indices.get(index);
            System.out.println(prev);
        }

        return true;

    }

    public static int UpperBound (List<Integer> indices, int target){
        int l=0;
        int h=indices.size()-1;

        while(l<=h){
            int mid=l+(h-l)/2;
            if(indices.get(mid)<=target){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return l;
    }
}
