package Easy2;

import Easy.TreeNode;

/**
 * 235题
 * 二叉搜索树(BST)的最小共同祖先问题（LCA,lowest common ancestor）
 *
 * 总结下面几种方法都是利用了BST二叉搜索树的特点
 * Created by ly on 2016/10/26.
 */
public class LowestCommonAncestor {
    // BST树的特性
    // 如果P,Q都比ROOT小，则都在左子树；如果P,Q都比root大，则都在右子树；否则分列两边
    // 10ms
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null|| p==null || q==null)
            return null;
        if(Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(Math.min(p.val, q.val) > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    //11ms
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        return left==null ? right : right==null ? left : root;
    }

    //9ms
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return null;
        if(p == null)   return q;
        if(q == null)   return p;
        TreeNode b = p.val > q.val ? p : q;
        TreeNode s = p.val < q.val ? p : q;
        TreeNode curr = root;
        while(curr != null && (curr.val > b.val || curr.val < s.val)) {
            if(curr.val > b.val)    curr = curr.left;
            if(curr.val < s.val)    curr = curr.right;
        }
        return curr;
    }

    //8ms
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        for(;;) {
            if((p.val-root.val)*(q.val-root.val) <= 0)  return root;
            if(p.val < root.val)    root = root.left;
            else    root = root.right;
        }
    }
}
