import java.util.*;
public class PrefixOfCommonArrayOfTwoArray {

public static void main(String [] args){
    int [] A={1,3,2,4};
    int [] B={3,1,2,4};
    findThePrefixCommonArray(A,B);


}


    public static  int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=A.length;
        int count=0;
        int [] res=new int[n];
        for(int i=0;i<n;i++){
            map.put(A[i],map.getOrDefault(map.get(A[i]),0)+1);
            if(map.get(A[i])==2){
                count++;
            }
            map.put(B[i],map.getOrDefault(map.get(B[i]),0)+1);

            if(map.get(B[i])==2){
                count++;
            }

            res[i]=count;
        }
        return res;
    }
}
