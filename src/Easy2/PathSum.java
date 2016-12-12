package Easy2;

import Easy.TreeNode;

/**
 * 112题
 * 二叉树从根节点到叶子节点路径和是否等于指定值
 * Created by ly on 2016/12/12.
 */
public class PathSum {
    //1ms
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && sum-root.val==0)
            return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        PathSum p = new PathSum();
        System.out.println(p.hasPathSum(t.test(), 8));
    }
}
