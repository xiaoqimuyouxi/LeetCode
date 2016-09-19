package Easy;

//206Ã‚
public class ReverseLinkedList {

	//1ms
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
	
	//√ª∂Æ£ø£ø
	public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
          return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = second.next;
        ListNode temp = null;
        first.next = null;
        while(third != null){
            temp = second;
            second.next = first;
            first = temp;
            second = third;
            third = second.next;
        }
        second.next = first;
        return second;
    }
}
