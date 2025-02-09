import java.util.*;
public class DesignANumberContainerSystem {

    public static void main(String [] args){
        NumberContainers nc=new NumberContainers();

        /*
[[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
        */

        System.out.println(nc.find(10));
        nc.change(2,10);
        nc.change(1,10);
        nc.change(3,10);
        nc.change(5,10);
        System.out.println(nc.find(10));
        nc.change(1,20);
        System.out.println(nc.find(10));



    }

    static  class NumberContainers {
        HashMap<Integer,Integer> idxToNum;
        HashMap<Integer,PriorityQueue<Integer>> numToIdx;
        public NumberContainers() {
            idxToNum=new HashMap<>();
            numToIdx=new HashMap<>();
        }

        public void change(int index, int number) {
            idxToNum.put(index,number);
            numToIdx.putIfAbsent(number,new PriorityQueue<>());
            numToIdx.get(number).add(index);
        }

        public int find(int number) {
            if(!numToIdx.containsKey(number)){
                return -1;
            }
            PriorityQueue<Integer> pq=numToIdx.get(number);
            //  System.out.println(pq);
            while(!pq.isEmpty()){
                int idx=pq.peek();

                if(idxToNum.get(idx)==number){
                    return idx;
                }
                pq.poll();
            }
            return -1;
        }
    }
}
