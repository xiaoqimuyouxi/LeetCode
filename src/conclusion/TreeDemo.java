package conclusion;

import Easy.TreeNode;
import Easy2.PalindromeLinkedList;
import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.*;

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

    /**
     * 将二叉查找树变为有序的双向链表 要求不能创建新节点，只调整指针。
     *      节点的左即为链表前一节点，右即为链表后一节点
     * 递归解法：
     * 参考了http://stackoverflow.com/questions/11511898/converting-a-binary-search-tree-to-doubly-linked-list#answer-11530016
     * 感觉是最清晰的递归解法，但要注意递归完，root会在链表的中间位置，因此要手动
     * 把root移到链表头或链表尾
     * @param root
     * @return
     */
    public static TreeNode convertBST2DLL1(TreeNode root) {
        root = convertBST2DLLSub(root);

        // root会在链表的中间位置，因此要手动把root移到链表头
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * 递归转换二叉查找树为双向链表(DLL)
     */
    public static TreeNode convertBST2DLLSub(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode tmp = null;
        if(root.left != null) {     //处理左子树
            tmp = convertBST2DLLSub(root.left);
            while (tmp.right != null) { //寻找最右节点
                tmp = tmp.right;
            }
            tmp.right = root;   //把左子树处理后结果和root连接
            root.left = tmp;
        }
        if(root.right != null) {    //处理右子树
            tmp = convertBST2DLLSub(root.right);
            while (tmp.left != null) {  //寻找最左节点
                tmp = tmp.left;
            }
            tmp.left = root;    //把右子树处理后结果和root连接
            root.right = tmp;
        }
        return root;
    }

    /**
     * 二叉查找树转换为双向链表，迭代解法
     *      基本思想同中序遍历二叉树
     * @param root
     * @return
     */
    public static TreeNode convertBST2DLL2(TreeNode root) {
        if(root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;    //指向当前正在处理的节点
        TreeNode old = null;    //前一节点
        TreeNode head = null;   //双向链表的头结点

        while (true) {
            while (cur != null) {   //将所有左节点全部入栈
                stack.push(cur);
                cur = cur.left;
            }

            if(stack.isEmpty()) {
                break;
            }

            //由于此时没有左孩子了，所以输出栈顶元素
            cur = stack.pop();
            if(old != null) {
                old.right = cur;
            }
            if(head == null) {  //第一个结点为双向链表头结点
                head = cur;
            }
            old = cur;  //更新old
            cur = cur.right;    //准备处理右子树
        }
        return head;
    }

    /**
     * 求二叉树中两个节点的最低公共祖先节点
     * 递归解法：
     * （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
     * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
     */
    public static TreeNode getLastCommonParent(TreeNode root, TreeNode n1, TreeNode n2) {
        if(findNode(root.left, n1)) {    //如果节点n1在树的左子树
            if(findNode(root.right, n2)) {  //节点n2在树的右子树
                return root;
            }
            else {  //节点n2也在左子树，则递归处理左子树
                return getLastCommonParent(root.left, n1, n2);
            }
        }
        else {  //n1在右子树
            if(findNode(root.left, n2)) {
                return root;
            }
            else {
                return getLastCommonParent(root.right, n1, n2);
            }
        }
    }

    //递归判断一个节点是否在树里
    public static boolean findNode(TreeNode root, TreeNode n) {
        if(root == null || n == null) {
            return false;
        }
        if(root == n) {
            return true;
        }
        //先尝试在左子树里查找
        boolean found = findNode(root.left, n);
        if(!found) {    //如果不在左子树中
            found = findNode(root.right, n);    //在右子树中查找
        }
        return found;
    }

    //求二叉树中两个节点的最低公共祖先节点，更加简便的递归方法
    public static TreeNode getLastCommonParent1(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null) {
            return null;
        }
        //如果两者有一个与root 相同
        if(root.equals(n1) || root.equals(n2)) {
            return root;
        }

        TreeNode commonInLeft = getLastCommonParent1(root.left, n1, n2);
        TreeNode commonInRight = getLastCommonParent1(root.right, n1, n2);

        //如果一个在左子树找到一个在右子树找到，则为root
        if(commonInLeft != null && commonInRight != null) {
            return root;
        }
        //其他情况要不然在左子树要不然在右子树
        if(commonInLeft != null) {
            return commonInLeft;
        }
        return commonInRight;
    }

    /**
     * 求二叉树中节点的最大距离 即二叉树中相距最远的两个节点之间的距离。 (distance / diameter)
     * 递归解法：
     * （1）如果二叉树为空，返回0，同时记录左子树和右子树的深度，都为0
     * （2）如果二叉树不为空，最大距离要么是左子树中的最大距离，要么是右子树中的最大距离，
     * 要么是左子树节点中到根节点的最大距离+右子树节点中到根节点的最大距离，
     * 同时记录左子树和右子树节点中到根节点的最大距离。
     *
     * http://www.cnblogs.com/miloyip/archive/2010/02/25/1673114.html
     *
     * 计算一个二叉树的最大距离有两个情况:

     情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
     情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
     只需要计算这两个情况的路径距离，并取其大者，就是该二叉树的最大距离
     * @param root
     * @return
     */
    public static Result getMaxDistance(TreeNode root) {
        if(root == null) {
            Result empty = new Result(0, -1);   // 目的是让调用方 +1 后，把当前的不存在的 (NULL) 子树当成最大深度为 0
            return empty;
        }
        //计算出左右子树分别最大距离
        Result lmd = getMaxDistance(root.left);
        Result rmd = getMaxDistance(root.right);

        Result res = new Result();
        res.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth)+1;  //计算最大深度
        //取情况A和情况B中较大值
        res.maxDistance = Math.max(lmd.maxDepth+rmd.maxDepth, Math.max(lmd.maxDistance, rmd.maxDistance));
        return res;
    }

    private static class Result {
        int maxDistance;
        int maxDepth;
        public Result() {

        }
        public Result(int maxDistance, int maxDepth) {
            this.maxDistance = maxDistance;
            this.maxDepth = maxDepth;
        }
    }

    /**
     * 把从根节点出发到node节点的路径所有经过的节点添加到路径path中
     * @param root
     * @param node
     * @param path
     * @return
     */
    public static boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if(root == null) {
            return false;
        }
        path.add(root); //先将根节点添加到路径中
        if(root == node) {
            return true;
        }
        boolean found = getNodePath(root.left, node, path); //在左子树中找node节点
        if(!found) {    //左子树中没有node节点，在右子树中查找
            found = getNodePath(root.right, node, path);
        }
        if(!found) {    //如果左右子树中都不存在node节点，则将之前加到path中的root节点删除
            path.remove(root);
        }
        return found;
    }

    /**
     * 根据前序遍历序列和中序遍历序列重建二叉树
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static TreeNode rebuildBinaryTreeByPreAndIn(List<TreeNode> preOrder, List<TreeNode> inOrder) {
        TreeNode root = null;   //定义二叉树根节点
        List<TreeNode> leftPreOrder;    //左子树前序遍历序列
        List<TreeNode> rightPreOrder;   //右子树前序遍历序列
        List<TreeNode> leftInOrder;     //左子树中序遍历序列
        List<TreeNode> rightInOrder;    //右子树中序遍历序列
        int preNum = 0;
        int inNum = 0;

        if((!preOrder.isEmpty()) && (!inOrder.isEmpty())) {
            root = preOrder.get(0); //前序遍历的第一个节点即为根节点

            //根据root的位置，可以确定inOrder左边的是左子树序列，右边的是右子树序列
            inNum = inOrder.indexOf(root);  //找到root在inOrder中的位置
            leftInOrder = inOrder.subList(0, inNum);    //左子树中序遍历序列
            rightInOrder = inOrder.subList(inNum+1, inOrder.size());    //右子树中序遍历序列

            preNum = leftInOrder.size();    //前序序列的分割点
            leftPreOrder = preOrder.subList(1, preNum+1);
            rightPreOrder = preOrder.subList(preNum+1, preOrder.size());

            root.left = rebuildBinaryTreeByPreAndIn(leftPreOrder, leftInOrder);   // root的左子树就是preorder和inorder的左侧区间而形成的树
            root.right = rebuildBinaryTreeByPreAndIn(rightPreOrder, rightInOrder);
        }
        return root;
    }

    /**
     * 根据中序和后序遍历序列重建二叉树
     * @param inOrder
     * @param postOrder
     * @return
     */
    public static TreeNode rebuildBinaryTreeByInAndPost(List<TreeNode> inOrder, List<TreeNode> postOrder) {
        TreeNode root = null;   //新建根节点
        List<TreeNode> leftInOrder;
        List<TreeNode> rightInOrder;
        List<TreeNode> leftPostOrder;
        List<TreeNode> rightPostOrder;
        int inNum = 0;
        int postNum = 0;

        if((inOrder.size() != 0) && (postOrder.size() != 0)) {
            root = postOrder.get(postOrder.size()-1);   //后序遍历序列的最后一个节点即为根节点

            //由root节点的位置可以分割中序遍历序列
            inNum = inOrder.indexOf(root);
            leftInOrder = inOrder.subList(0, inNum);
            rightInOrder = inOrder.subList(inNum+1, inOrder.size());

            postNum = leftInOrder.size();   //后序遍历序列的左右子树分割点
            leftPostOrder = postOrder.subList(0, postNum);
            rightPostOrder = postOrder.subList(postNum, postOrder.size());

            root.left = rebuildBinaryTreeByInAndPost(leftInOrder, leftPostOrder);
            root.right = rebuildBinaryTreeByInAndPost(rightInOrder, rightPostOrder);
        }
        return root;
    }

    /**
     * 判断二叉树是否为完全二叉树，迭代
     *  若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
     第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
     有如下算法，按层次（从上到下，从左到右）遍历二叉树，当遇到一个节点的左子树为空时，
     则该节点右子树必须为空，且后面遍历的节点左右子树都必须为空，否则不是完全二叉树。
     * @param root
     * @return
     */
    public static boolean isCompleteBinaryTree1(TreeNode root) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean mastHaveNoChild = false;
        boolean result = false;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();  //队列先进先出
            if(mastHaveNoChild){    // 已经出现了有空子树的节点了，后面出现的必须为叶节点（左右子树都为空）
                if(cur.left != null || cur.right != null) {
                    result = false;
                    break;
                }
            }
            else {
                if(cur.left == null && cur.right != null) { //如果左子树为空，右子树非空则说明不是完全二叉树
                    result = false;
                    break;
                }
                else if(cur.left != null && cur.right == null) {    //如果左子树非空，右子树为空，则左子节点不能有左右子树
                    mastHaveNoChild = true;
                    queue.add(cur.left);
                }
                else if(cur.left != null && cur.right != null) {    //如果左右子孩子都非空，则加入队列继续循环
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
                else {  // 如果左右子树都为空，则后面的必须也都为空子树
                    mastHaveNoChild = true;
                }
            }
        }
        return result;
    }

    /**
     * 判断二叉树是否是完全二叉树，递归解法
     * @param root
     * @return
     */
    public static boolean isCompleteBinaryTree2(TreeNode root) {
        return isCompleteTree(root).height != -1;
    }

    public static Pair isCompleteTree(TreeNode root) {
        if(root == null) {
            return new Pair(0, true);
        }
        Pair left = isCompleteTree(root.left);
        Pair right = isCompleteTree(root.right);

        //如果左树是满树，且左右子树同高度，则是唯一可能形成满树（右树也是满树）的情况
        if(left.isFull && left.height == right.height) {
            return new Pair(1+left.height, right.isFull);
        }

        //左树非满，但右树是满树，且左树比右树高度高1
        if(right.isFull && left.height == right.height +1) {
            return new Pair(left.height+1, false);
        }
        //其他情况都不是完全二叉树
        return new Pair(-1, false);
    }

    private static class Pair {
        int height; //树的高度
        boolean isFull; //是否是满树

        public Pair(int height, boolean isFull) {
            this.height = height;
            this.isFull = isFull;
        }
    }
}
