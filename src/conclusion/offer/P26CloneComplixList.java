package conclusion.offer;

/**
 * Created by ly on 2017/8/7.
 */
public class P26CloneComplixList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        cloneNodes(pHead);

        //依次遍历N'的random指向S'
        RandomListNode node = pHead;
        while (node != null) {
            if(node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        //将两个短链表从长链表中分离
        node = pHead;
        RandomListNode nHead = null;
        RandomListNode newNode = null;
        if(node != null) {
            nHead = newNode = node.next;
            node.next = newNode.next;
            node = node.next;
        }

        while (node != null) {
            newNode.next = node.next;
            newNode = newNode.next;
            node.next = newNode.next;
            node = node.next;
        }
        return nHead;
    }

    //复制节点N -> N' ，组成长链表
    public void cloneNodes(RandomListNode pHead) {
        RandomListNode originNode = pHead;
        while(originNode != null) {
            RandomListNode newNode = new RandomListNode(originNode.label);
            newNode.next = originNode.next;
            newNode.random = null;
            originNode.next = newNode;
            originNode = newNode.next;
        }
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
