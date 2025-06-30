import java.util.ArrayList;
import java.util.List;

public class CheckIfthereExistsASubsequencewithSumK {
    public  static List<List<Integer>> res=new ArrayList<>();
    public static void main(String [] args){
        int [] arr= {1, 2, 3, 4, 5} ;
        int K = 8;
        checkSubsequenceSum(arr,K);
        for(List<Integer> temp:res){
            System.out.println(temp);
        }

    }

    public static void solve(int idx, ArrayList<Integer> temp,int [] arr, int K,int N,int [] sum){
        if(idx>=N){
            if(sum[0]==K){
                res.add(new ArrayList<>(temp));
            }
        }
        if(idx<N){
            temp.add(arr[idx]);
            sum[0]+=arr[idx];
            solve(idx+1,temp,arr,K,N,sum);
            temp.remove(temp.size()-1);
            sum[0]-=arr[idx];
            solve(idx+1,temp,arr,K,N,sum);
        }

    }
    public static  List<List<Integer>> checkSubsequenceSum(int[] arr, int K) {
        int N=arr.length;
        boolean ans1=false;
        boolean ans2=true;
        int [] sum={0};
        ArrayList<Integer> temp=new ArrayList<>();
        solve(0,temp,arr,K,N,sum);
        return res;
    }
}
