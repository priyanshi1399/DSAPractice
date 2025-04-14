import java.util.*;
public class FruitsIntoBasket {

    public static void main(String [] args){
    int [] fruits = {1,2,3,2,2};
    totalFruit(fruits);
    }

    public static int totalFruit(int[] fruits) {
        int n=fruits.length;
        int maxFruits=0;

        for(int i=0;i<n;i++){

            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i;j<n;j++){

                map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
                if(map.size()==2){
                    int sum=0;
                    for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                        sum=sum+entry.getValue();
                    }
                    maxFruits=Math.max(maxFruits,sum);
                }
                else if (map.size()>2){
                    break;
                }
            }

           /* else if(map.size()>2){
                map.clear();
            }*/


        }
        return maxFruits;

    }
}
