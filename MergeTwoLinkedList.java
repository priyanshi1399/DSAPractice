public class MergeTwoLinkedList {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};

        ListNode list1=createListNode(arr1);
        ListNode list2=createListNode(arr2);

        mergeTwoLists(list1,list2);
    }

    public static ListNode createListNode(int [] arr){
        int n=arr.length;
        ListNode dummy=new ListNode(0);
        ListNode current=dummy;
        for(int i=0;i<n;i++){
        current.next=new ListNode(arr[i]);
        current=current.next;
        }
        return dummy.next;
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;

            }
            temp = temp.next;
        }

        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }

        return result.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}




