package Easy2;

/**
 * Created by ly on 2016/10/23.
 */
public class ListNode {
    int val;
    ListNode next;

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
}
