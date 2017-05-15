import Easy.ListNode;
import Easy.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ly on 2016/12/23.
 */
public abstract class Main {

    public Main() {

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo);
        test(demo);
        System.out.println(demo);
        int a = 8;
        long test = 012;
        test1(a);
        int x = 1;
        float y = 2;
        System.out.println(x/y);

    }

    private static int d ;
    public void setD(int d) {
        this.d = d;
    }

    private static void test(Demo demo){
        demo = null;
    }

    private static void test1(int s){
        s++;
//        Main m = new Main();
//        m.setD(45);

    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre == null || in == null ||
                pre.length == 0 || in.length == 0 ||
                pre.length != in.length) {
            return null;
        }
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();

        for (int i = 0; i < pre.length; i++) {
            preList.add(pre[i]);
        }
        for (int i = 0; i < in.length; i++) {
            inList.add(in[i]);
        }

        return rebuild(preList, inList);
    }

    public TreeNode rebuild(List<Integer> pre, List<Integer> in) {
        TreeNode root = null;

        List<Integer> leftOfPre;	//二叉树的左子树前序遍历序列
        List<Integer> rightOfPre;

        List<Integer> leftOfIn;	//二叉树右子树前序遍历序列
        List<Integer> rightOfIn;

        int inNum, preNum;

        if(!pre.isEmpty() && !in.isEmpty()){
            //根据前序遍历序列可以得到二叉树的根节点
            root = new TreeNode(pre.get(0));

            inNum = in.indexOf(pre.get(0));

            leftOfIn = in.subList(0, inNum);    //二叉树左子树的中序遍历序列
            rightOfIn = in.subList(inNum+1, in.size());

            preNum = leftOfIn.size();   //左子树中的节点个数
            leftOfPre = pre.subList(1, preNum+1);
            rightOfPre = pre.subList(preNum+1, pre.size());

            root.left = rebuild(leftOfPre, leftOfIn);
            root.right = rebuild(rightOfPre, rightOfIn);
        }
        return root;
    }

}

