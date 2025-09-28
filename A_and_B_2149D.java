import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_and_B_2149D {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            solve(sc);

        }

    }
    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        String str = sc.next();
        List<Integer> aList=new ArrayList<>();
        List<Integer> bList=new ArrayList<>();

        for(int i=0;i<n;i++){
            char c=str.charAt(i);

            if (c == 'a') {
                aList.add(i+1);
            } else {
                bList.add(i+1);
            }
        }

        System.out.println(Math.min(findCost(aList), findCost(bList)));
        }


    public static  long findCost(List<Integer> list){
        if (list.isEmpty()) return 0;
       int pos=list.size()/2;
        long cost=0;
        for(int i=0;i<list.size();i++){
            cost+=Math.abs(list.get(pos)-list.get(i))-Math.abs(pos-i);
        }
        return cost;


    }
}
