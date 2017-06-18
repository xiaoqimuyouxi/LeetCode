package conclusion.offer;

import Easy.TreeNode;

import java.util.ArrayList;

/**
 * Created by ly on 2017/6/18.
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if(root == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int currentSum = 0;
        FindPath(root,target,paths,currentSum, path);

        return paths;
    }

    //重载
    public void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> paths, int currentSum, ArrayList<Integer> path) {
        currentSum += root.val;
        path.add(root.val);

        boolean isLeaf = false;
        if(root.left == null && root.right == null) {
            isLeaf = true;
        }

        if(currentSum == target && isLeaf) {
            ArrayList<Integer> pathList = new ArrayList<>(path);//如果没有这一步，那么最后结果都为空
            paths.add(pathList);
        }

        if(root.left != null) {
            FindPath(root.left, target, paths, currentSum, path);
        }
        if(root.right != null) {
            FindPath(root.right, target, paths, currentSum, path);
        }

        path.remove(path.size()-1);     //在返回父节点之前，在路径上删除当前节点
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(12);

        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n5;

        FindPath f = new FindPath();
        ArrayList<ArrayList<Integer>> paths = f.findPath(n1, 22);
        int index = 1;
        for(ArrayList<Integer> path : paths) {
            System.out.println("第 " + index++ + " 条路径：");
            for(int i : path) {
                System.out.print(i + "-->");
            }
            System.out.println();
        }
    }
}
