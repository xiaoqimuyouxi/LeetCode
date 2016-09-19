package Easy;

/**
 * 19题
 * 删除链表尾部的第n个结点
 * @author ly
 *
 */
public class RemoveNodeFromList {

	//两趟完成，遍历两次	16ms
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) {
			return head;
		}
		else if(head.next == null && n == 1) {
			return null;
		}
		
		//获取链表长度，先遍历一次
        int length = 0;		//链表长度
        ListNode node1 = head;
        while(node1 != null) {
        	length++;
        	node1 = node1.next;
        }
        
        //再遍历第二次
        ListNode node = head;
        for(int i = 1; i < length-n; i++) {
        	node = node.next;
        }
        if(n == 1) {	//如果删去最后一个结点
        	node.next = null;
        }
        else if(n == length) {	//如果删除链表第一个结点
        	return head.next;
        }
        else {
        	node.next = node.next.next;
        }
        
        return head;
    }
	
	//一趟完成,只遍历一次	15ms
	//使用两个指针，node,secNode,第一个指针比第二个快n步,当node走到链表末尾时
	//secNode刚好走了length-n步
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode node = head;
		for(int i = 0; i < n; i++) {
			node = node.next;
		}
		
		if(node == null) {   //如果删除的是第一个元素
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
