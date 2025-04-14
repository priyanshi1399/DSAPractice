import java.util.*;
public class LinkedListCycle2 {

    public  static void main(String [] args){
        int [] dummy = {3,2,0,-4};
        int pos = 1;
        ListNode head= convertToLinkedList(dummy);
        detectCycle(head);
    }

    public  static  class ListNode{
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

    public static ListNode convertToLinkedList(int [] dummy){
        ListNode result=new ListNode(0);
        ListNode temp=result;

        for(int i=0;i<dummy.length;i++){
            temp.next=new ListNode (dummy[i]);
            temp=temp.next;
        }
        return result.next;

    }


    public static ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }


        }
        if(fast==null || fast.next==null){
            return null;
        }
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;


    }
}
