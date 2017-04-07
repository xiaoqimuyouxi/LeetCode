package conclusion;

import Easy.TreeNode;
import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by ly on 2017/4/7.
 */
@SuppressWarnings("All")
public class TreeDemo {
    /*
                 1
                / \
               2   3
              / \   \
             4  5   6
     */
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;

//        preOrder1(r1);
//        System.out.println("前序遍历，递归");
//        preOrder2(r1);
//        System.out.println("前序遍历，迭代");
//
//        inOrder1(r1);
//        System.out.println("中序遍历，递归");
//        inOrder2(r1);
//        System.out.println("中序遍历，迭代");

//        postOrder1(r1);
//        System.out.println("后序遍历，递归");
//        postOrder2(r1);
//        System.out.println("后序遍历，迭代");

//        levelOrder1(r1);
//        System.out.println("层序遍历，迭代");
//        levelOrder2(r1);
//        System.out.println("层序遍历， 递归");

//        System.out.println(getDepth1(r1));
//        System.out.println(getDepth2(r1));

        System.out.println(getNodesNum1(r1));
        System.out.println(getNodesNum2(r1));
    }


    /**
     * 前序遍历，递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     * @param root
     */
    public static void preOrder1(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");

        preOrder1(root.left);
        preOrder1(root.right);
    }

    /**
     * 前序遍历，迭代
     *      用一个辅助stack，总是把右孩子放进栈
     * @param root
     */
    public static void preOrder2(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop(); //出栈顶元素
            System.out.print(cur.val + " ");

            // 关键点：要先压入右孩子，再压入左孩子，这样在出栈时会先打印左孩子再打印右孩子
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历，递归
     * @param root
     */
    public static void inOrder1(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder1(root.left);
        System.out.print(root.val + " ");
        inOrder1(root.right);
    }

    /**
     * 中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内，
     * 然后输出栈顶元素，再处理栈顶元素的右子树
     * http://www.youtube.com/watch?v=50v1sJkjxoc
     *
     * 还有一种方法能不用递归和栈，基于线索二叉树的方法，较麻烦以后补上
     * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/

     */
    public static void inOrder2(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (true) {
            while (cur != null) {   // 先添加一个非空节点所有的左孩子到栈
                stack.push(cur);
                cur = cur.left;
            }

            if(stack.isEmpty()) {
                break;
            }

            // 因为此时已经没有左孩子了，所以输出栈顶元素
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    /**
     * 后序遍历，递归
     * @param root
     */
    public static void postOrder1(TreeNode root) {
        if(root == null) {
            return;
        }

        postOrder1(root.left);
        postOrder1(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 后序遍历，迭代
     * @param root
     */
    public static void postOrder2(TreeNode root) {
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

    /**
     * 分层遍历二叉树（按层次从上往下，从左往右）迭代
     * 相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。当队列不为空，进行如下操作：弹出一个节点
     * @param root
     */
    public static void levelOrder1(TreeNode root) {
        if(root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            System.out.print(cur.val + " ");

            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 层序遍历，递归
     * 很少有人会用递归去做level traversal
     *  基本思想是用一个大的ArrayList，里面包含了每一层的ArrayList。
     *  大的ArrayList的size和level有关系
     *
     *  这是我目前见到的最好的递归解法！
     *  http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal#answer-container-2543
     * @param root
     */
    public static void levelOrder2(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0, ret);
        System.out.print(ret);
     }

    public static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret) {
        if(root == null) {
            return;
        }
        if(level >= ret.size()) {
            ret.add(new ArrayList<Integer>());
        }
        ret.get(level).add(root.val);   //把节点值加入到表示那一层的list集合中
        dfs(root.left, level+1, ret);
        dfs(root.right, level+1, ret);
    }

    /**
     * 求二叉树的深度（高度） 递归解法： O(n)
     * （1）如果二叉树为空，二叉树的深度为0
     * （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
     * @param root
     * @return
     */
    public static int getDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getDepth1(root.left);
        int right = getDepth1(root.right);
        return Math.max(left, right)+1;
    }

    /**
     * 求二叉树的深度（高度） 迭代解法： O(n)
     * 基本思想同LevelOrder，还是用一个Queue
     * @param root
     * @return
     */
    public static int getDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int depth = 0;
        int currentLevelNodes = 1;  //当前层的节点数
        int nextLevelNodes = 0; //下一层的节点数
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst(); //从队头位置开始移除
            currentLevelNodes--;    //当前层数节点减1
            if(cur.left != null) {  //当前节点有左子节点，加入队列中
                queue.add(cur.left);
                nextLevelNodes++;   //并将下一层节点数加1
            }
            if(cur.right != null) {
                queue.add(cur.right);
                nextLevelNodes++;
            }
            if(currentLevelNodes == 0) {    //如果处理完当前层的所有节点
                depth++;    //深度加1
                currentLevelNodes = nextLevelNodes; //初始化当前层为下一层
                nextLevelNodes = 0;
            }
        }
        return depth;
    }

    /**
     * 二叉树的节点个数，递归
     * @param root
     * @return
     */
    public static int getNodesNum1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getNodesNum1(root.left);
        int right = getNodesNum1(root.right);
        return left + right + 1;
    }

    /**
     * 二叉树的节点个数，迭代
     * @param root
     * @return
     */
    public static int getNodesNum2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int count = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if(cur.left != null) {
                queue.add(cur.left);
                count++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                count++;
            }
        }
        return count;
    }

    /**
     * 判断两颗二叉树是否为相同的二叉树,递归
     * @param r1
     * @param r2
     * @return
     */
    public static boolean isSameTree1(TreeNode r1, TreeNode r2) {
        // 如果两棵二叉树都为空，返回真
        if(r1 == null && r2 == null) {
            return true;
        }
        // 如果两棵二叉树一棵为空，另一棵不为空，返回假
        else if(r1 == null || r2 == null) {
            return false;
        }

        if(r1.val != r2.val) {
            return false;
        }

        boolean left = isSameTree1(r1.left, r2.left);    //分别比较左子树和右子树是否相等
        boolean right = isSameTree1(r1.right, r2.right);
        return left && right;
    }

    /**
     * 判断两颗二叉树是否相同，迭代解法
     * @param r1
     * @param r2
     * @return
     */
    public static boolean isSameTree2(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) {
            return true;
        }
        else if(r1 == null || r2 == null) {
            return false;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.add(r1);
        s2.add(r2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            if(n1 == null && n2 == null) {
                continue;
            }
            else if(n1!=null && n2 != null && n1.val == n2.val) {
                s1.push(n1.right);
                s1.push(n1.left);
                s2.push(n2.right);
                s2.push(n2.left);
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断二叉树是不是平衡二叉树 递归解法：
     * （1）如果二叉树为空，返回真
     * （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
     * @param root
     * @return
     */
    public static boolean isAVL(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(getDepth1(root.left) - getDepth1(root.right)) > 1) {
            return false;
        }
        return isAVL(root.left) && isAVL(root.right);
    }

    /**
     * 求二叉树中叶子节点的个数，递归
     * @param root
     * @return
     */
    public static int getLeafNodeNum1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeNum1(root.left) + getLeafNodeNum1(root.right);
    }

    /**
     * 求二叉树中叶子节点的个数，迭代
     *      基于层序遍历的思想
     * @param root
     * @return
     */
    public static int getLeafNodeNum2(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if(cur.left == null && cur.right == null) {
                count++;
            }
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
        return count;
    }

    /**
     * 求二叉树第K层节点的个数
     * （1）如果二叉树为空或者k<1返回0
     * （2）如果二叉树不为空并且k==1，返回1
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
     *
     * 求以root为根的k层节点数目 等价于 求以root左孩子为根的k-1层（因为少了root那一层）节点数目 加上
     * 以root右孩子为根的k-1层（因为少了root那一层）节点数目
     *
     * 所以遇到树，先把它拆成左子树和右子树，把问题降解
     * @param root
     * @return
     */
    public static int getKthLevelNodesNum1(TreeNode root, int k) {
        if(root == null || k < 1) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }

        int left = getKthLevelNodesNum1(root.left, k-1);     //求root左子树的k-1层节点数
        int right = getKthLevelNodesNum1(root.right, k-1);
        return left+right;
    }

    /**
     * 求二叉树第K层节点数目，迭代
     * @param root
     * @param k
     * @return
     */
    public static int getKthLevelNodesNum2(TreeNode root, int k) {
        if(root == null || k < 1) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevelNodes = 1;
        int nextLevelNodes = 0;
        int i = 1;

        while (!queue.isEmpty() && i < k) {
            TreeNode cur = queue.removeFirst(); //移除队头位置
            currentLevelNodes--;    //当前层节点数减1
            if(cur.left != null) {
                queue.add(cur.left);
                nextLevelNodes++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                nextLevelNodes++;
            }
            if(currentLevelNodes == 0) {
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                i++;
            }

        }
        return currentLevelNodes;
    }
}
