package Easy;

/**
 * 404��
 * �������������Ҷ�ӽ��ĺ�
 * @author ly
 *
 */
public class SumOfLeftLeaves {

	//9ms
	public static int sumOfLeftLeaves(TreeNode root) {
		if(root == null)
			return 0;
		
		if(root.left != null && root.left.left == null && root.left.right==null) {
			return root.left.val + sumOfLeftLeaves(root.right);
		}
		
		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
	
	//11ms
	public static int sumOfLeftLeaves1(TreeNode root) {
		if(root == null)
			return 0;
		int result = 0;
		if(root.left != null) {
			if( root.left.left == null && root.left.right == null)
				result += root.left.val;
			else
				result += sumOfLeftLeaves(root.left);
		}
		if(root.right != null) 
			result += sumOfLeftLeaves(root.right);
		
		return result;
	}
}
