package Easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 104题，求二叉树的最大深度
 * @author ly
 *
 */
public class MaxDepBinTree {

	//1ms	递归
	public static int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		int i, j;
		if(root.left != null) {
			i = maxDepth(root.left);
		}
		else
			i = 0;
		if(root.right != null) {
			j = maxDepth(root.right);
		}
		else
			j = 0;
		return i>j?i+1:j+1;
	}
	
	//1ms
	public static int maxDepth1(TreeNode root) {
		if(root == null)
			return 0;
		return 1+Math.max(maxDepth1(root.left), maxDepth1(root.right));
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
		
		/**
		 * String[] s = {"1", "2"};
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("1", "2"));
		System.out.println(list);
		 */
		
		
		System.out.println(maxDepth(node1));
	}
}
