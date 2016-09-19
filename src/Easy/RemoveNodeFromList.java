package Easy;

/**
 * 19题
 * 删除链表尾部的第n个结点
 * @author ly
 *
 */
public class RemoveNodeFromList {

	//16ms	自己写的Naive Two Passes
	//两趟完成，遍历两次
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) {
			return head;
		}
		else if(head.next == null && n == 1) {
			return null;
		}
        int length = 0;
        ListNode node1 = head;
        while(node1 != null) {
        	length++;
        	node1 = node1.next;
        }
        ListNode node = head;
        for(int i = 1; i < length-n; i++) {
        	node = node.next;
        }
        if(n == 1) {
        	node.next = null;
        }
        else if(n == length) {
        	return head.next;
        }
        else {
        	node.next = node.next.next;
        }
        
        return head;
    }
	
	//15ms	One Pass
	//一趟完成
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode node = head;
		for(int i = 0; i < n; i++) {
			node = node.next;
		}
		
		if(node == null) {
			return head.next;
		}
		
		ListNode secNode = head;
		while(node.next != null) {
			secNode = secNode.next;
			node = node.next;
		}
		secNode.next = secNode.next.next;
		return head;
	}
}
