package Easy;

/**
 * 100��
 * �Ƚ����������Ƿ����
 * @author ly
 *
 */
public class SameTree {

	//0ms
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null)
			return true;
		if(p==null || q==null)
			return false;
		if(p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
