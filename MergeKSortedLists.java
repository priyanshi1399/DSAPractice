import java.util.*;
public class MergeKSortedLists {

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(){

        }
        public ListNode(int val){
            this.val=val;

        }
        public ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;

        }


    }
    public static void main(String [] args){
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 4, 5));
        lists.add(Arrays.asList(1, 3, 4));
        lists.add(Arrays.asList(2, 6));

        ListNode[] listNodes=new ListNode[lists.size()];
        for(int i=0;i< lists.size();i++){
            listNodes[i]=createLinkedList(lists.get(i));
        }
        mergeKLists(listNodes);
    }

    public static ListNode createLinkedList(List<Integer> lst){
        if(lst==null || lst.isEmpty()){
            return null;
        }
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        for(int i=0;i<lst.size();i++){
            temp.next=new ListNode(lst.get(i));
            temp=temp.next;
        }
        return dummy.next;
    }

    public  static ListNode mergeKLists(ListNode[] lists) {
        int k=lists.length;
        if(k==0){
            return null;
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(k, new
                Comparator<ListNode> () {
                    @Override
                    public int compare(ListNode l1,ListNode l2){
                        return l1.val-l2.val;
                    }
                });

        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }

        }
        while(!pq.isEmpty()){
            ListNode top=pq.poll();
            temp.next=top;
            temp=top;
            if(top.next!=null){
                pq.add(top.next);
            }
        }
        return dummy.next;

    }
}
