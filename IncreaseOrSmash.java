import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IncreaseOrSmash {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();

        for(int j=0;j<t;j++){
            int n=sc.nextInt();
            int [] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int ans=solve(arr);
            System.out.println(ans);
        }


    }
    public static int solve(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        return 2*map.size()-1;
    }



}
