package Easy;

/**
 * 226题
 * 交换二叉树中左右两个孩子节点
 * @author ly
 *
 */
public class InvertBinaryTree {

	//0ms
	public static TreeNode invertTree(TreeNode root) {
		
		if(root == null) 
			return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
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
		
		TreeNode root = invertTree(node1);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.left.val);
	}
}
