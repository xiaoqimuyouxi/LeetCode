package conclusion.offer;


import exercise.Tree;

/**
 * Created by ly on 2017/8/7.
 */
public class P27SearchTree2List {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }

        //1. 将左子树构造成双链表
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        //2. 定位到左子树双链表的最后一个节点处
        while (p != null && p.right != null) {
            p = p.right;
        }
        //3. 如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        //4. 将右子树构造成双链表
        TreeNode right = Convert(pRootOfTree.right);
        //5. 如果右子树链表不为空的话，将右子树链表加到root后面
        if(right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }

        return left!=null ? left : pRootOfTree;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(14);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(16);

        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.left = n6;
        n5.right = n7;

        P27SearchTree2List list = new P27SearchTree2List();
        TreeNode head = list.Convert(n1);
        while (head != null) {
            System.out.print(head.val + "   ");
            head = head.right;
        }
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}