package exercise;

import Easy2.ListNode;
import org.junit.Test;

/**
 * Created by ly on 2017/5/4.
 */
public class ReverseListTest {

    @Test
    public void testReverseList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode head = ReverseList.reverseList(null);
        while (head != null) {
            System.out.print(head.val + "   ");
            head = head.next;
        }
    }
}
