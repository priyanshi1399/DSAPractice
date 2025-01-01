import java.util.*;
public class OddEvenLinkedList {

    public static void main(String [] args){
        int [] temp= {1,2,3,4,5};

        ListNode head=ArrayToList(temp);
        oddEvenList(head);
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=head.next;
        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;

            odd=odd.next;
            even=even.next;

        }
        odd.next=evenHead;
        return head;

    }


    public static ListNode ArrayToList(int [] arr){
        if(arr.length==0){
            return null;
        }
        ListNode head=new ListNode(0);
        ListNode current=head;


        for(int i=0;i<arr.length;i++){
            current.next=new ListNode(arr[i]);
            current=current.next;
        }
        return head.next;
    }

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(){

        }
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }

}
