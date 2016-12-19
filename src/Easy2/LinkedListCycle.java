package Easy2;

import java.util.HashSet;
import java.util.Set;

/**
 * 141题
 * 判断链表中有没有环
 * Created by ly on 2016/12/8.
 */
public class LinkedListCycle {
    //9ms
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while(head.next != null) {
            if(set.contains(head.next))
                return true;
            set.add(head.next);
            head = head.next;
        }
        return false;
    }

    /**
     * 思路：采用“快慢指针”查检查链表是否含有环。让一个指针一次走一步，
     * 另一个一次走两步，如果链表中含有环，快的指针会再次和慢的指针相遇。
     *
     * 1ms
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        /**
         * 这里需要注意的一点是算法中循环的条件，这是一个很容易被忽略的细节。

         1）因为fast指针比slow指针走得快，所以只要判断fast指针是否为空就好。由于fast指针一次走两步（走得太快了，就容易跌倒！），
         fast.next可能已经为空（当fast为尾结点时），fast.next.next将会导致NullPointerException异常，所以在while循环中我们要判断fast.next是否为空；

         2）考虑一个特殊情况，当输入的链表为空时，算法应该返回false，空链表肯定是不含有环的。如果没有fast != null，
         也会导致fast.next抛出NullPointerException异常。

         TIPS：时刻记着考虑算法的健壮性，当算法的输入为null时会怎样？
         */
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode head = listNode.generateList(new int[]{});
        System.out.println(hasCycle1(head));

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        //该例子会超时,相遇点是入口点
        System.out.println(hasCycle1(n1));
    }
}
