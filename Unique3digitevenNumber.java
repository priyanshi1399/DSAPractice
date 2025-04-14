import java.util.*;
public class Unique3digitevenNumber {

        public  static void main(String [] args){
            int [] digits = {1,2,3,4};
            totalNumbers(digits);

        }
    private static void solve(int idx, int [] digits, int n,StringBuilder curr,HashSet<String> set,boolean [] visited){
        if(curr.length()==3 && Integer.parseInt(curr.toString())>99
                && Integer.parseInt(curr.toString())<999 && Integer.parseInt(curr.toString())%2==0 ){
            set.add(curr.toString());
            return;
        }

        for(int i=idx;i<n;i++){
            if(visited[i]==true){
                continue;
            }
            visited[i]=true;
            curr=curr.append(digits[i]);
            solve(idx,digits,n,curr,set,visited);

            curr.deleteCharAt(curr.length()-1);
            visited[i]=false;
        }
    }
    public  static int totalNumbers(int[] digits) {
        int n=digits.length;
        //int [] dp=new int[n+1];
        StringBuilder curr=new StringBuilder();
        boolean [] visited=new boolean[n];
        HashSet<String> set=new HashSet<>();
        solve(0,digits,n,curr,set,visited);
        return set.size();
    }
    }

