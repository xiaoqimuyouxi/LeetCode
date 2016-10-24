package Easy2;

/**
 * 83题
 * 删除有序单链表中重复的节点
 * Created by ly on 2016/10/23.
 */
public class RemoveDuplicatesfromSortedList {
    //1ms
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)    return null;
        ListNode tmp = head;
        while(tmp.next != null) {
            while(tmp.next != null && tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            }
            if(tmp.next == null)
                break;
            tmp = tmp.next;
        }
        return head;
    }
}
