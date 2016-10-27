package Easy2;

/**
 * 21题
 * 合并两个有序链表
 * Created by ly on 2016/10/27.
 */
public class MergeTwoSortedLists {
    //16ms  迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;

        if(l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    //17ms
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode(0);
        ListNode start = merge;
        while (l1 != null || l2 != null) {
            if(l1 == null) {
                start.next = l2;
                return merge.next;
            }
            if(l2 == null) {
                start.next = l1;
                return merge.next;
            }
            if(l1.val < l2.val) {
                start.next = l1;
                l1 = l1.next;
                start = start.next;
            }
            else {
                start.next = l2;
                l2 = l2.next;
                start = start.next;
            }
        }
        return merge.next;
    }
}
