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

    public ListNode test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        return n1;
    }
}
