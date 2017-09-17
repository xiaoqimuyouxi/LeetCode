package conclusion.offer;

import java.util.Stack;

/**
 * Created by ly on 2017/9/14.
 */
public class P19TreeMirror {
    public void Mirror(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    //利用前序遍历的思想
    public void Mirror2(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();

            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
}
