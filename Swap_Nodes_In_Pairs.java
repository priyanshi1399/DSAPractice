import java.util.*;
public class Swap_Nodes_In_Pairs {

    public static class ListNode{
        int val;
        ListNode next;

        public  ListNode(int data){
            this.val=data;
        }

        public ListNode(int data, ListNode next){
            this.val=data;
            this.next=next;
        }
    }
    public static void main(String [] args ){
        int [] arr={1,2,3,4,5,6};
        ListNode head=convertToLinkedList(arr);

        swapPairs(head);
    }
    public static ListNode convertToLinkedList(int [] arr){

       ListNode dummy=new ListNode(0);
       ListNode temp=dummy;
        for(int i=0;i<arr.length;i++){
            temp.next=new ListNode(arr[i]);
            temp=temp.next;

        }
        return dummy.next;
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=head.next;
        head.next=swapPairs(head.next.next);
        temp.next=head;
        return temp;
    }
}
