package Easy2;

import Easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 107题
 * 从下至上层序遍历二叉树中的节点，每一层节点集是一个list，返回二叉树的节点集List<List<Integer>>
 * Created by ly on 2016/11/15.
 */
public class BinaryTreeLevelOrderTraversalII {
    //5ms  递归
    //在从上至下的递归层序遍历中得到的结果再反转
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        System.out.println(result.size());
        int first = 0;
        int end = result.size()-1;
        while(first < end) {
            List<Integer> tmp = result.get(first);
            result.add(first, result.get(end)); //在指定索引位置插入交换的数据
            result.remove(first+1); //如果在插入之前删除会出现越界问题
            result.add(end, tmp);
            result.remove(end+1);
            first++;
            end--;
        }
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

        BinaryTreeLevelOrderTraversalII b = new BinaryTreeLevelOrderTraversalII();
        System.out.println(b.levelOrderBottom(node1));
    }
}
