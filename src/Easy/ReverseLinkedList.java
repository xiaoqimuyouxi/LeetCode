package Easy;

//206题
public class ReverseLinkedList {

	//1ms	递归
	//把一个直接调用自己，或通过一系列的调用语句简介地调用自己的函数，称为递归函数
	//大量的递归调用会建立函数的副本，会耗费大量的时间和内存
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
	
	//迭代
	public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
          return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = second.next;
        ListNode temp = null;
        first.next = null;	//first与second指向断开
        while(third != null){
            temp = second;		//temp指针下移
            second.next = first;	//second指向first,不再指向third
            first = temp;		//first下移到second
            second = third;		//second下移到third
            third = second.next;	//third到原来third的下一个
            //一次循环下来，first到second反向，second到third为空，所有指针全部下移一位
        }
        second.next = first;
        return second;
    }
}
