package Easy;

//206��
public class ReverseLinkedList {

	//1ms	�ݹ�
	//��һ��ֱ�ӵ����Լ�����ͨ��һϵ�еĵ��������ص����Լ��ĺ�������Ϊ�ݹ麯��
	//�����ĵݹ���ûὨ�������ĸ�������ķѴ�����ʱ����ڴ�
	public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null) {
    	   return head;
       }
       
       ListNode secNode = head.next;
       ListNode rest = reverseList(secNode);
       secNode.next = head;
       head.next = null;
       return rest;
       
    }
	
	//����
	public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
          return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = second.next;
        ListNode temp = null;
        first.next = null;	//first��secondָ��Ͽ�
        while(third != null){
            temp = second;		//tempָ������
            second.next = first;	//secondָ��first,����ָ��third
            first = temp;		//first���Ƶ�second
            second = third;		//second���Ƶ�third
            third = second.next;	//third��ԭ��third����һ��
            //һ��ѭ��������first��second����second��thirdΪ�գ�����ָ��ȫ������һλ
        }
        second.next = first;
        return second;
    }
}
