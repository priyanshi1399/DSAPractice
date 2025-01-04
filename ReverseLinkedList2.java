import java.util.*;

public class ReverseLinkedList2 {


    public static void main(String [] args){
       int []  arr = {1,2,3,4,5};
               int left = 2;
       int right = 4;
      ListNode head= convertarrayToLinkedList(arr);
      reverseBetween(head,left,right);
    }

    public static ListNode convertarrayToLinkedList(int [] arr){
        ListNode temp =new ListNode(0);
        ListNode current=temp;
        for(int i=0;i<arr.length;i++){
            current.next=new ListNode(arr[i]);
            current=current.next;
        }
        return temp.next;
    }
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(){

        }
        public ListNode(int val){
            this.val=val;
        }

        public ListNode(ListNode next,int val){
            this.val=val;
            this.next=next;
        }
    }



    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head; //[5] dummy=null-->5
        ListNode prev=dummy; //prev=null return dummy .next;

        for(int i=1;i<=left-1;i++){
            prev=prev.next;
        }
        System.out.println(prev);

        ListNode curr=prev.next;
        for(int i=0;i<right-left;i++){
            ListNode f=curr.next;
            curr.next=f.next;
            f.next=prev.next;
            prev.next=f;
        }
        return dummy.next;
    }
}
