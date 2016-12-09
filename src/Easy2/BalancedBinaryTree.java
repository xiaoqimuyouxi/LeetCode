package Easy2;

import Easy.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * 110题
 * 平衡二叉树，每个节点的左右子树深度相差不超过1
 * Created by ly on 2016/12/9.
 */
public class BalancedBinaryTree {
    //递归    2ms
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        //左子树深度与右子树深度相差大于1，就是非平衡二叉树
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
            return false;
        boolean leftBa = isBalanced(root.left);
        boolean rightBa = isBalanced(root.right);

        //递归判断左子树与右子树是否是平衡二叉树
        return leftBa && rightBa;
    }

    //二叉树的深度计算，递归解法
    public int getDepth(TreeNode root) {
        if(root == null)
            return 0;
        //二叉树左右子树深度的最大值+1才是二叉树的深度
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }

    //7ms   对于计算二叉树深度迭代法没有递归法快
    public boolean isBalanced1(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(getDepth1(root.left) - getDepth1(root.right)) > 1)
            return false;
        boolean leftBa = isBalanced(root.left);
        boolean rightBa = isBalanced(root.right);

        //递归判断左子树与右子树是否是平衡二叉树
        return leftBa && rightBa;
    }

    //迭代计算二叉树深度
    public int getDepth1(TreeNode root) {
        if(root == null)
            return 0;
        int depth = 0;
        int currentLevelNodes = 1;  //当前层所包含的节点数
        int nextLevelNodes = 0;     //下一层所包含的节点数

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.remove();  //从队头移除元素
            currentLevelNodes--;
            if(cur.left != null) {  //如果节点有左孩子
                queue.add(cur.left);
                nextLevelNodes++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                nextLevelNodes++;
            }

            if(currentLevelNodes == 0) {    //如果该层的所有节点已经遍历完成
                depth++;
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.right = n3;
        BalancedBinaryTree b = new BalancedBinaryTree();
        System.out.println(b.isBalanced1(n1));
    }
}
