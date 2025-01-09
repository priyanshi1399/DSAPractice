import  java.util.*;
public class ReorderList {

    public static void main(String [] args){
    int [] curr = {1,2,3,4,5,6,7,8};
    ListNode head=convertToLinkedList(curr);
    reorderList(head);
    }
    public static  ListNode convertToLinkedList(int [] arr){

        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;

        for(int i=0;i<arr.length;i++){
            temp.next=new ListNode(arr[i]);
            temp=temp.next;
        }

        return dummy.next;
    }

    public static void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode secondHalf=slow.next;
        slow.next=null;
        secondHalf=reverse(secondHalf);
        ListNode firstHalf=head;

        while(firstHalf!=null && secondHalf!=null){
            ListNode temp1=firstHalf.next;
            ListNode temp2=secondHalf.next;

            firstHalf.next=secondHalf;
            secondHalf.next=temp1;
            firstHalf=temp1;
            secondHalf=temp2;
        }
    }

    public static ListNode reverse(ListNode head){

        ListNode prev=null;
        ListNode curr=head;
        ListNode n=head;

        while(curr!=null){
            n=curr.next;
            curr.next=prev;
            prev=curr;
            curr=n;
        }

        return prev;
    }

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
}
