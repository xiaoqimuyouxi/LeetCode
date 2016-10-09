package Easy;

/**
 * 111题		求二叉树的最小深度
 * 根节点到最近叶子节点的距离
 * @author ly
 *
 */
public class MinDepBinTree {

	//1ms
	public static int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		else if(root.left == null) {
			return 1+minDepth(root.right);
		}
		else if(root.right == null) {
			return 1+minDepth(root.left);
		}
		else {
			int i = minDepth(root.left);
			int j = minDepth(root.right);
			return 1+Math.min(i, j);
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.right = node6;
		
		System.out.println(minDepth(node1));
	}
}
