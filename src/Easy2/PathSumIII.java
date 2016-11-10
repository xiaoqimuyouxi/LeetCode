package Easy2;

import Easy.TreeNode;

import java.util.HashMap;

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

    //17ms
    public int pathSum1(TreeNode root, int sum) {
        //key键为每个节点到根节点中间所有元素的总和，value值表示到这个总和的几种方式（不重要）
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return Helper(root, 0, sum, map);
    }

    public int Helper(TreeNode root, int sum, int target, HashMap<Integer, Integer> map) {
        if(root == null)
            return 0;
        sum += root.val;
        //如果map中存在sum-target这个键就返回value值，否则即为默认的0
        int res = map.getOrDefault(sum-target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        res += Helper(root.left, sum, target, map) + Helper(root.right, sum, target, map);
        map.put(sum, map.getOrDefault(sum, 0)-1);
        return res;

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
        int count = path.pathSum1(node1, 3);

        System.out.println(count);
    }
}
