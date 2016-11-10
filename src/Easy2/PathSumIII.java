package Easy2;

import Easy.TreeNode;

/**
 * 437题
 * 找到二叉树中指定总和的路径数
 * Created by ly on 2016/10/27.
 */
public class PathSumIII {
    //32ms
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int count = pathWithRoot(root,sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return count;
    }
    public int pathWithRoot(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int count = 0;
        if(root.val == sum)
            count++;
        count += pathWithRoot(root.left, sum-root.val) + pathWithRoot(root.right, sum-root.val);
        return count;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        node5.right = node6;

        PathSumIII path = new PathSumIII();
        int count = path.pathSum(node1, 3);

        System.out.println(count);
    }
}
