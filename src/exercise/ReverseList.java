package exercise;

import Easy2.ListNode;

/**
 * 单链表反转
 * Created by ly on 2017/5/4.
 */
public class ReverseList {

    //单链表反转
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        //截止条件，当cur指针指向链表尾节点时
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre; //反转后的头结点
    }


}
