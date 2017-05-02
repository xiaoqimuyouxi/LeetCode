package exercise;

import Easy.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 练习二叉树
 * Created by ly on 2017/5/2.
 */
@SuppressWarnings("all")
public class Tree {

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);

        r1.left = r2;
        r2.left = r4;
        r2.right = r5;
        r1.right = r3;
        r3.right = r6;

//        preOrder(r1);
//        inOrder(r1);
//        postOrder(r1);
        levelOrder(r1);
    }

    //前序遍历，非递归
    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            System.out.print(cur.val + " ");

            if(cur.right != null) {    //先压右节点再压入左节点，这样弹出的时候会先弹出左节点
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //中序遍历，非递归
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        //死循环
        while (true) {
            while (cur != null) {   //循环将左节点压入栈中
                stack.push(cur);
                cur = cur.left;
            }

            if(stack.isEmpty()) {
                break;
            }

            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;    //遍历右节点
        }
    }

    //后序遍历，非递归
    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            out.push(cur);

            if(cur.left != null) {
                stack.push(cur.left);
            }
            if(cur.right != null) {
                stack.push(cur.right);
            }
        }

        while (!out.isEmpty()) {
            System.out.print(out.pop().val + " ");
        }
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            System.out.print(cur.val + " ");

            if(cur.left != null) {
                queue.addLast(cur.left);
            }
            if(cur.right != null) {
                queue.addLast(cur.right);
            }
        }
    }
}
