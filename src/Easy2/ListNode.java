package Easy2;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){}
    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode generateList(int[] arr) {
        if(arr.length==0)   return null;
        ListNode head = new ListNode(arr[0]);
        if(arr.length == 1)
            return head;
        ListNode tmp = head;
        for(int i = 1; i < arr.length; i++) {
            ListNode nextNode = new ListNode(arr[i]);
            tmp.next = nextNode;
            tmp = nextNode;
        }
        return head;
    }

    public static void returnList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
}
