package Easy;

/**
 * 237��
 * ɾ���������е�һ���ڵ㣨β�ڵ���⣩
 * @author ly
 *
 */
public class DeleteNoteinLinkedList {
	//1ms
	//���������޷��ҵ���ɾ���ڵ�node��ǰһ�ڵ㣬����ֻ�ܽ�������һ���ڵ㸳ֵ����Ȼ��ɾ����һ�ڵ�
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
