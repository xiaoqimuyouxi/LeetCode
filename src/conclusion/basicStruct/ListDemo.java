package conclusion.basicStruct;

import Easy2.ListNode;

import java.util.Stack;

/**
 * 链表题汇总
 * 1、计算单链表个数 getNodesNum
 * 2、单链表反转 tranverseList
 * 3、查找链表中倒数第k位置的节点 getLastKthNode
 * 4、查找链表中间节点位置 getMiddleNode
 * 5、从尾到头打印单链表 printListByDesc
 * 6、将两个有序的单链表合并成一个有序单链表 mergeSortedList1
 * 7、判断单链表中是否有环 isCycle
 * 8、判断两个链表是否相交 isIntersected
 * 9、求两个单链表相交的第一个节点 getFirstCommonNode
 * 10、求有环单链表进入环的第一个节点 getFirstNodeInTheCycle
 * 11、用O(1)时间复杂度删除单链表中指定节点  deleteNode
 * 12、复杂链表的复制   clone
 * Created by ly on 2017/4/9.
 */
@SuppressWarnings("All")
public class ListDemo {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(12);
        ListNode n4 = new ListNode(24);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(11);
        ListNode n8 = new ListNode(12);
        ListNode n9 = new ListNode(24);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

//        System.out.println("单链表节点个数：" + getNodesNum(n1));

//        System.out.println("反转单链表：");
//        printList(tranverseList(n1));

//        System.out.println("倒数第k位置的节点：" + getLastKthNode(n1, 8).val);
//        System.out.println("查找中间节点：" + getMiddleNode(n1).val);

//        System.out.println("逆序打印链表：");
//        printListByDesc1(n1);

//        printList(mergeSortedList1(n1, n5));
//        System.out.println(isIntersected(n1, n5));
//        System.out.println(getFirstCommonNode(n1, n5).val);

//        System.out.println(getFirstNodeInTheCycle(n1).val);
        printList(n5);
        deleteNode(n5, n7);
        printList(n5);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 计算单链表中的节点个数
     * @param root
     * @return
     */
    public static int getNodesNum(ListNode head) {
        if(head == null) {
            return 0;
        }
        int cout = 0;
        while (head != null) {
            cout++;
            head = head.next;
        }
        return cout;
    }

    /**
     * 反转单链表
     *      采用两个指针依次往后移动
     * @param root
     * @return
     */
    public static ListNode tranverseList(ListNode head) {
        //如果链表为空或只有一个节点，则直接返回链表头结点即为反转后的链表
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;    //设置前一节点指针为空
        ListNode cur = head;    //当前正在处理节点指针为头结点

        while (cur != null) {
            ListNode tmp = cur.next;    //保存当前节点下一节点，以免链表反转导致丢失这一节点
            cur.next = pre; //反转指向
            pre = cur;  //两个指针后移
            cur = tmp;
        }
        return pre;
    }

    /**
     * 查找链表中倒数第k位置的节点
     *  1）常用方法是先遍历所有链表找到链表节点总数n,然后遍历链表找到第（n-k）个节点   O(2n-k)
     *  2)这里采用两个指针，前一个指针先走到第k个节点的位置，此时前后指针距离相差k-1，然后两个
     *      指针一起往后走，当前一个节点走到最后一个结点时，后一个节点正好走到倒数第k个节点的位置
     * @param head
     * @param k
     * @return
     */
    public static ListNode getLastKthNode(ListNode head, int k) {
        if(k == 0 || head == null) {
            return null;
        }
        ListNode pAhead = head;
        ListNode pBehind = head;
        while (k > 1 && pAhead != null) {     //前一个节点先走到正数第k的位置
            pAhead = pAhead.next;
            k--;
        }
        if(k > 1) { //如果k比链表节点总数还大，则直接返回空
            return null;
        }
        //两个指针一起向后走
        while (pAhead.next != null) {   //当前一个节点走到最后一个节点位置时，后一个节点所处位置即为所求位置
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }

    /**
     * 查找链表中间节点
     *      思路同上，不同之处在于，两个指针同时向前走，但前一指针每次走两步，后一指针每次只走一步。
     *      到前一指针走到最后一个节点时，后一指针正好走到中间节点位置
     * @param head
     * @return
     */
    public static ListNode getMiddleNode(ListNode head) {
        //链表为空或只有一个节点，则返回头指针
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pAhead = head;
        ListNode pBehind = head;
        while (pAhead.next != null) {   //两个指针同时向前走，直到前一指针走到最后一个结点
            pAhead = pAhead.next;
            pBehind = pBehind.next;
            if(pAhead.next != null) {
                pAhead = pAhead.next;
            }
        }
        return pBehind;
    }

    /**
     * 从尾到头打印单链表
     *      对于逆序的思维，考虑用Stack先进后出的功能，时间复杂度O(n)
     * @param head
     */
    public static void printListByDesc(ListNode head) {
        if(head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        while (head.next != null) {
            head = head.next;
            stack.push(head);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }
    }

    /**
     * 从尾到头打印单链表，递归
     * @param head
     */
    public static void printListByDesc1(ListNode head) {
        if(head == null) {
            return;
        }
        else {
            printListByDesc1(head.next);
            System.out.print(head.val + " ");
        }
    }

    /**
     * 合并两个有序的单链表为一个有序单链表
     *      基本思路同归并排序，时间复杂度O(max(len1,len2))
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeSortedList(ListNode head1, ListNode head2) {
        if(head1 == null) { //如果其中一条单链表为空，则直接返回另一条
            return head2;
        }
        if(head2 == null) {
            return head1;
        }

        ListNode resHead = null;    //合并后的头结点
        if(head1.val <= head2.val) {
            resHead = head1;
            head1 = head1.next;
            resHead.next = null;
        }
        else {
            resHead = head2;
            head2 = head2.next;
            resHead.next = null;
        }

        ListNode tmpRes = resHead;
        while (head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                tmpRes.next = head1;
                head1 = head1.next;
                tmpRes = tmpRes.next;
                tmpRes.next = null; //将合并链表最后一个节点的下一节点设为空，否则它将指向head1的next
            }
            else {
                tmpRes.next = head2;
                head2 = head2.next;
                tmpRes = tmpRes.next;
                tmpRes.next = null; //道理同上
            }
        }
        if (head1 != null) {
            tmpRes.next = head1;
        }
        else if (head2 != null) {
            tmpRes.next = head2;
        }
        return resHead;
    }

    /**
     * 合并两个有序链表为一个有序的单链表，递归
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeSortedList1(ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }

        ListNode resHead = null;
        if(head1.val <= head2.val) {
            resHead = head1;
            resHead.next = mergeSortedList1(head1.next, head2);
        }
        else {
            resHead = head2;
            resHead.next = mergeSortedList1(head1, head2.next);
        }
        return resHead;
    }

    /**
     * 判断单链表中是否有环
     *      采用两个指针，快指针每次走两步，慢指针每次走一步，一直往下走，如果有环则两个指针总会相遇，
     *      如果无环，则快指针会先走到链表尾
     * @param head
     * @return
     */
    public static boolean isCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {  //相遇，则存在环
                return true;
            }
        }
        return false;
    }

    /**
     * 判断两个链表是否相交
     *      如果两个链表相交于一个顶点，那么两条链表在这个顶点以后的节点都相同，所以最后一个节点肯定也相同
     *      基本思路：先遍历第一个链表找到最后一个结点，再遍历第二条链表找到最后一个节点，如果这两个节点相同则证明两个
     *          链表相交
     */
    public static boolean isIntersected(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
            return false;
        }
        ListNode tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }
        ListNode tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        if(tail1 == tail2) {
            return true;
        }
        return false;
    }

    /**
     * 计算两条链表相交的第一个节点
     *      1）遍历链表1，得到链表1长度len1，以及最后一个节点tail1
     *      2）遍历链表2，得到链表2长度len2，以及最后一个节点tail2
     *      3）如果tail1 != tail2，则两条链表不相交直接返回空
     *      4）如果len1>len2,则先遍历链表1 len1-len2 个节点，此时两个链表到第一个相交节点的位置就相等了
     *          两个链表一起向后遍历，知道得到第一个相等的节点
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode getFirstCommonNode(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        int len1 = 1;
        ListNode tail1 = head1;
        while (tail1.next != null) {    //遍历链表1，获得其尾节点，以及长度
            tail1 = tail1.next;
            len1++;
        }
        int len2 = 1;
        ListNode tail2 = head2;
        while (tail2.next != null) {   //遍历链表2，获得其尾节点，以及长度
            tail2 = tail2.next;
            len2++;
        }
        if(tail1 != tail2) {    //两个链表不相交,直接返回空
            return null;
        }

        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        if(len1 > len2) {   //移动指针到离第一个相交节点距离相同的位置
            int i = len1-len2;
            while (i > 0) {
                tmp1 = tmp1.next;
                i--;
            }
        }
        else {
            int i = len2-len1;
            while (i > 0) {
                tmp2 = tmp2.next;
                i--;
            }
        }
        while (tmp1 != tmp2) {
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
        }
        return tmp1;
    }

    /**
     * 已知一个单链表中存在环，求进入环中的第一个节点
     *      1）判断单链表中是否存在环，若存在则继续
     *      2）在环中的一个节点处断开（当然函数结束时不能破坏原链表），这样就形成了两个相交的单链表,
     *          求进入环中的第一个节点也就转换成了求两个单链表相交的第一个节点
     */
    public static ListNode getFirstNodeInTheCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) { //判断是否成环
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) { //如果链表中无环
            return null;
        }

        ListNode assumedTail = slow;    //将环中的节点slow变为假想的尾节点，将问题转换成两个单链表相交问题
        ListNode head1 = head;
        ListNode head2 = assumedTail.next;

        //head1,head2两个链表相交求第一个相交点问题
        int len1 = 1;
        ListNode node1 = head1;
        while (node1 != assumedTail) {
            node1 = node1.next;
            len1++;
        }

        int len2 = 1;
        ListNode node2 = head2;
        while (node2 != assumedTail) {
            node2 = node2.next;
            len2++;
        }

        node1 = head1;
        node2 = head2;
        // 先对齐两个链表的当前结点，使之到尾节点的距离相等
        if(len1 > len2) {
            int i = len1-len2;
            while (i > 0) {
                node1 = node1.next;
                i--;
            }
        }
        else {
            int i = len2-len1;
            while (i > 0) {
                node2 = node2.next;
                i--;
            }
        }
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    /**
     * 给出一单链表头指针pHead和一节点指针pToBeDeleted，O(1)时间复杂度删除节点pToBeDeleted
     *      对于删除节点，我们普通的思路就是让该节点的前一个节点指向该节点的下一个节点，
     *      这种情况需要遍历找到该节点的前一个节点，时间复杂度为O(n)。
     *
     *      对于链表，链表中的每个节点结构都是一样的，所以我们可以把该节点的下一个节点的数据复制到该节点，
     *      然后删除下一个节点即可。要注意最后一个节点的情况，这个时候只能用常见的方法来操作，先找到前一个节点，但总体的平均时间复杂度还是O(1)
     */
    public static void deleteNode(ListNode head, ListNode node) {
        if(head == null || node == null) {
            return;
        }
        ListNode pre = head;
        if(node.next != null) { //当需要删除的节点不是最后一个结点时
            ListNode tmp = node.next;   //复制该节点下一节点的数据到该节点
            node.val = tmp.val;
            node.next = tmp.next;
        }
        else {  //删除节点是最后一个节点时
            if(head == node) {  //链表中只有一个节点的情况
                head = null;
            }
            else {
                while (pre.next != node) {  //循环找到要删除节点的前一节点
                    pre = pre.next;
                }
                if(pre.next == node) {
                    pre.next = null;
                }
            }

        }
    }

    /**
     * 复杂链表结构
     */
    private static class ComplexListNode {
        int val;
        ComplexListNode next;
        ComplexListNode any;    //指向链表中的任意节点或者NULL

        public ComplexListNode(int val) {
            this.val = val;
        }
        public ComplexListNode() {

        }
    }

    /**
     * 复杂链表的复制
     *
     * 解题方法：
     *  方法1：第一步复制原始链表上每一个节点，并用next指针连接起来；
     *      第二步设置每个节点的any指针域，每找一个就要从原始链表的头部开始遍历查找
     *      该方法时间复杂度是O(n^2)，空间复杂度O(1)
     *  方法2：第一步同上，并建立原始链表与复制链表之间的hash表；
     *      第二步设置每个节点的any指针域，这时候可以直接在hash表中查找；
     *      时间复杂度O(n),空间复杂度O(n)
     *  方法3：第一步复制原始链表的任意节点N并创建新节点N'，再把N'连接到N的next域
     *      第二步设置每个节点的any指针域，因为N'是N的next指向的节点，那么N的any指向的节点的next即为N'的any指向的节点
     *      第三步把长链表拆分成两个链表，把奇数位置的节点用next相连就是原始链表，偶数位置的节点用next相连就是复制链表
     *      时间复杂度是O(n)
     *
     *  以下主要实现第三种方法
     */
    public static ComplexListNode clone(ComplexListNode head) {
        cloneNodes(head);
        connectAnyNode(head);
        return reconnectNode(head);
    }

    //第一步复制节点并创建新节点，且把新节点连接到原节点的next域
    //A -> B -> C -> D
    //A -> A' -> B - > C -> D
    public static void cloneNodes(ComplexListNode head) {
        ComplexListNode repeatNode = head;
        while (repeatNode != null) {
            ComplexListNode cloned = new ComplexListNode();
            cloned.val = repeatNode.val;
            cloned.next = repeatNode.next;
            cloned.any = null;

            repeatNode.next = cloned;
            repeatNode = cloned.next;
        }
    }

    //第二步设置每个节点的any指针域，因为N'是N的next指向的节点，那么N的any指向的节点的next即为N'的any指向的节点
    public static void connectAnyNode(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode cloned = node.next;
            if(node.any != null) {
                cloned.any = node.any.next;
            }
            node = cloned.next;
        }
    }

    //把第二步得到的链表拆分成两个链表
    //A -> A' -> B -> B' -> C -> C' -> D -> D'
    //A -> B -> C -> D      A' -> B' -> C' ->D'
    public static ComplexListNode reconnectNode(ComplexListNode head) {
        ComplexListNode newHead = null;
        ComplexListNode node = head;
        ComplexListNode newNode = null;
        if(node != null) {
            newHead = node.next;
            newNode = node.next;
            node.next = newNode.next;
            node = node.next;
        }

        while (node != null) {
            newNode.next = node.next;
            newNode = node.next;
            node.next = newNode.next;
            node = node.next;
        }
        return newHead;
    }
}
