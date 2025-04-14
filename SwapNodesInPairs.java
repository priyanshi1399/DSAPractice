import java.util.*;
public class SwapNodesInPairs {

    public static void main(String [] args){
            int [] curr = {1,2,3,4};
           ListNode head= ConvertArrayToLinkedList(curr);
           swapPairs(head);

        }
    public static  ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode first=head;
        ListNode second=head.next;
        ListNode temp1=second;
        ListNode temp2=second.next;
        while(second!=null || second.next!=null){
            int temp=first.val;
            first.val=second.val;
            second.val=temp;

            first=temp1;
            second=temp2;
        }
        return head;
    }


    public  static ListNode ConvertArrayToLinkedList(int [] arr){
            ListNode dummy=new ListNode(0);
            ListNode current=dummy;

            for(int i=0;i<arr.length;i++){
                current.next=new ListNode(arr[i]);
                current=current.next;
            }

            return dummy.next;
    }

    public static class ListNode{
            int val;
            ListNode next;
           public  ListNode(){

            }

            public  ListNode(int val){
               this.val=val;
            }

        public  ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
}
