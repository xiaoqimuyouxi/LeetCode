package Easy2;

/**
 * 203题     删除单链表中指定元素
 * Created by ly on 2016/12/21.
 */
public class RemoveLinkedListElements {
    //1ms
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)    return null;
        while(head.val == val) {
            if(head.next != null)
                head = head.next;
            else
                return null;
        }
        ListNode exc = head;
        while(exc != null && exc.next != null) {
            //这里使用while主要是为了解决碰到链表中连续的目标值问题
            while(exc.next.val == val) {
                if(exc.next.next != null)
                    exc.next = exc.next.next;
                else {
                    exc.next = null;
                    break;
                }
            }
            exc = exc.next;
        }
        return head;
    }

    //2ms
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null)    return null;
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    //2ms
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null)    return null;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode curr = head, pre = preHead;
        while(curr != null) {
            if(curr.val == val) {
                pre.next = curr.next;
            }
            else {
                pre = pre.next;
            }
            curr = curr.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements r = new RemoveLinkedListElements();
        int[] arr = {1,2,2,1};
        ListNode head = r.removeElements2(ListNode.generateList(arr), 1);
        ListNode.returnList(head);
    }
}
