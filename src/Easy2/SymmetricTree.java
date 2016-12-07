package Easy2;

import Easy.TreeNode;

import java.util.Stack;

/**
 * 101题     判断二叉树是否是对称数
 * Created by ly on 2016/12/7.
 */
public class SymmetricTree {
    //1ms 采用递归的方法
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        else if (root.left == null || root.right == null)
            return false;

        swap(root.left);

        //判断交换后的左子树是否与右子树相同
        return isSame(root.left, root.right);
    }

    //交换左子树的左右子树节点，递归下去
    public void swap(TreeNode root) {
        if(root.left == null && root.right == null)
            return;
        else if(root.left == null) {
            root.left = root.right;
            root.right = null;
            swap(root.left);    //放在条件语句之后会报空指针异常
        }
        else if(root.right == null) {
            root.right = root.left;
            root.left = null;
            swap(root.right);
        }
        else {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            swap(root.left);
            swap(root.right);
        }
    }

    /**
     * 判断两棵树是否相等
     * @param r1
     * @param r2
     * @return
     */
    public boolean isSame(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        else if (r1 == null || r2 == null)
            return false;

        if (r1.val != r2.val)
            return false;
        boolean leftComp = isSame(r1.left, r2.left);
        boolean rightComp = isSame(r1.right, r2.right);
        return leftComp && rightComp;
    }

    //3ms 采用迭代的方法
    public boolean isSymmetric1(TreeNode root) {
        if(root == null || (root.left==null && root.right==null))
            return true;
        else if(root.left == null || root.right == null)
            return false;

        if(root.left.val != root.right.val)
            return false;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root.left);
        s2.push(root.right);

        while(!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            if(n1 == null && n2 == null)
                continue;
            if(n1!=null && n2!=null && n1.val==n2.val) {
                s1.push(n1.right);  //这里与比较两个二叉树是否相等不同
                s1.push(n1.left);   //这里两个栈push下去的左右结点顺序不同
                s2.push(n2.left);
                s2.push(n2.right);
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(6);
        TreeNode node10 = new TreeNode(7);
        TreeNode node11 = new TreeNode(8);
        TreeNode node12 = new TreeNode(8);
        TreeNode node13 = new TreeNode(7);
        TreeNode node14 = new TreeNode(6);
        TreeNode node15 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node3.left = node6;
        node3.right = node7;
        node6.left = node12;
        node6.right = node13;
        node7.left = node14;
        node7.right = node15;

        SymmetricTree st = new SymmetricTree();

        System.out.println(st.isSymmetric1(node1));
    }
}