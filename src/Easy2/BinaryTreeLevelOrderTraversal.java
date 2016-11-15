package Easy2;

import Easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102题
 * 从上至下层序遍历二叉树中的节点，每一层节点集是一个list，返回二叉树的节点集List<List<Integer>>
 * Created by ly on 2016/11/15.
 */
public class BinaryTreeLevelOrderTraversal {
    //1ms  递归
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        /*层序遍历二叉树，迭代方法
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if(cur.left != null) {
                queue.push(cur.left);
            }
            if(cur.right != null) {
                queue.push(cur.right);
            }
        }*/

        dfs(root, 0, result);
        return result;
    }
    public static void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null)
            return ;
        //添加一个新的ArrayList表示新的一层
        if(level >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);   //获取level层的list并将当前节点数据添加进去
        dfs(root.left, level+1, res);   // 递归处理下一层的左子树和右子树
        dfs(root.right, level+1, res);
    }

    //迭代方法  2ms
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        if(root == null)
            return res;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.removeFirst();
                list.add(cur.val);
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        System.out.println(b.levelOrder1(node1));
    }
}
