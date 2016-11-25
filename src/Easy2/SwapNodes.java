package Easy2;

/**
 * 24题  交换单向链表中的节点对
 * Created by ly on 2016/11/25.
 */
public class SwapNodes {
    //迭代    5ms
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null)
            return head;
        ListNode tmp1;
        ListNode head1 = head.next;
        if(head.next != null) {
            tmp1 = swapPairs(head.next.next);
            head.next.next = head;
            head.next = tmp1;
        }
        return head1;
    }
}
