package Easy2;

import Easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102题
 * 层序遍历二叉树中的节点，每一层节点集是一个list，返回二叉树的节点集List<List<Integer>>
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
}
