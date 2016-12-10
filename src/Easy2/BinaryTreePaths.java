package Easy2;

import Easy.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 257题
 * 找出二叉树中所有根节点到叶子节点的路径
 * Created by ly on 2016/12/10.
 */
public class BinaryTreePaths {
    //2ms
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root != null)
            searchBT(root, "", list);
        return list;
    }
    public void searchBT(TreeNode root, String path, List<String> answers) {
        if(root.left == null && root.right == null)
            answers.add(path + root.val);
        if(root.left != null)
            searchBT(root.left, path + root.val + "->", answers);
        if(root.right != null)
            searchBT(root.right, path + root.val + "->", answers);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        BinaryTreePaths b = new BinaryTreePaths();
        System.out.println(b.binaryTreePaths(n1));
    }
}
