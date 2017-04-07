package exam;

import Easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 3月24日搜狐笔试题
 * <p/>
 * 二叉树所有节点为非零整数，求二叉树的最大子树。
 * 最大子树：当前节点与其所有子节点数值之和最大
 * <p/>
 * Created by ly on 2017/3/24.
 */
public class MaxSubTree {

    private int max = Integer.MIN_VALUE;

    public int getMaxSubTree(TreeNode root) {
        visit(root);
        return max;
    }

    public int visit(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val;
        if (root.left != null || root.right != null) {
            int left = visit(root.left);
            int right = visit(root.right);
            sum += (left + right);

            max = Math.max(sum, max);
        }
        return sum;
    }
}
