package Easy2;

import java.util.ArrayList;
import java.util.List;

/**
 * 234题，回文单链表
 * Created by ly on 2016/12/19.
 */
public class PalindromeLinkedList {
    //6ms
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

    public static void main(String[] args) {
        int[] arr = {-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,
                -10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557};
        int[] arr2 = {1,2,3,3,2,1};
        PalindromeLinkedList p = new PalindromeLinkedList();
        System.out.println(p.isPalindrome(ListNode.generateList(arr)));
    }
}
