package conclusion.offer;

import Easy.TreeNode;

/**
 * 树的子结构
 * 判断树B是否是树A的子结构
 * Created by ly on 2017/6/27.
 */
public class P18HasSubTree {
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if(root1 != null && root2 != null) {
            if(root1.val == root2.val) {
                res = doesTree1HasTree2(root1, root2);
            }
            if(!res) {
                res = hasSubTree(root1.left, root2);
            }
            if(!res) {
                res = hasSubTree(root1.right, root2);
            }
        }
        return res;
    }

    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if(root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }

        return doesTree1HasTree2(root1.left, root2.left) &&
                doesTree1HasTree2(root1.right, root2.right);
    }
}
