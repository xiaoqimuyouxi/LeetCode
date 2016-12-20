package Easy2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 234题，回文单链表
 * Created by ly on 2016/12/19.
 */
public class PalindromeLinkedList {
    //6ms   遍历整个链表，将链表每个节点的值记录在List集合中，再判断List集合是不是一个回文数组，
    // 时间复杂度为O（n），但空间复杂度也为O（n），不满足空间复杂度要求。
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null)
            return true;

        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int i = size/2-1;
        int j = size/2+size%2;
        while(i>=0&&j<size) {
            if(list.get(i).equals(list.get(j))) {
                i--;j++;
            }
            else {
                System.out.println(list.get(i) +"==="+list.get(j));
                return false;
            }
        }

        return true;
    }

    //4ms   利用栈先进后出的性质，将链表前半段压入栈中，再逐个弹出与链表后半段比较。
    // 时间复杂度O（n），但仍然需要n/2的栈空间，空间复杂度为O（n）。
    public boolean isPalindrome1(ListNode head) {
        if(head == null || head.next == null)
            return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        ListNode slow = head;
        ListNode fast = head;   //快指针比慢指针快两倍，所以快指针到链表末端时，慢指针刚好在中间
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);   //把链表前半段压入栈中
        }
        if(fast.next == null)
            stack.pop();    //共奇数个节点时将栈顶元素弹出
        while(slow.next != null) {
            int tmp = stack.pop();
            slow = slow.next;
            if(tmp != slow.val)
                return false;
        }
        return true;
    }

    //3ms   反转链表法，将链表后半段原地翻转，再将前半段、后半段依次比较，判断是否相等，
    // 时间复杂度O（n），空间复杂度为O（1）满足题目要求。
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode last = slow.next;
        //反转后半段链表
        while (last.next != null) {
            ListNode tmp = last.next;
            last.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }
        ListNode pre = head;
        //比较前半段与后半段
        while(slow.next != null) {
            slow = slow.next;
            if(pre.val != slow.val)
                return false;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,
                -10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557};
        int[] arr2 = {1,2,3,3,2,1};
        PalindromeLinkedList p = new PalindromeLinkedList();
        System.out.println(p.isPalindrome2(ListNode.generateList(arr)));
    }
}
