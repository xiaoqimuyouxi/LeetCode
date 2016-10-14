package Easy;

/**
 * 237题
 * 删除单链表中的一个节点（尾节点除外）
 * @author ly
 *
 */
public class DeleteNoteinLinkedList {
	//1ms
	//单向链表无法找到待删除节点node的前一节点，所以只能将他的下一个节点赋值给它然后删除下一节点
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
