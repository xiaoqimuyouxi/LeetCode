package Easy2;

import Easy.TreeNode;

import java.util.LinkedList;

/**
 * 110棰�
 * 骞宠　浜屽弶鏍戯紝姣忎釜鑺傜偣鐨勫乏鍙冲瓙鏍戞繁搴︾浉宸笉瓒呰繃1
 * Created by ly on 2016/12/9.
 */
public class BalancedBinaryTree {
    //閫掑綊    2ms
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        //宸﹀瓙鏍戞繁搴︿笌鍙冲瓙鏍戞繁搴︾浉宸ぇ浜�1锛屽氨鏄潪骞宠　浜屽弶鏍�
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
            return false;
        boolean leftBa = isBalanced(root.left);
        boolean rightBa = isBalanced(root.right);

        //閫掑綊鍒ゆ柇宸﹀瓙鏍戜笌鍙冲瓙鏍戞槸鍚︽槸骞宠　浜屽弶鏍�
        return leftBa && rightBa;
    }

    //浜屽弶鏍戠殑娣卞害璁＄畻锛岄�掑綊瑙ｆ硶
    public int getDepth(TreeNode root) {
        if(root == null)
            return 0;
        //浜屽弶鏍戝乏鍙冲瓙鏍戞繁搴︾殑鏈�澶у��+1鎵嶆槸浜屽弶鏍戠殑娣卞害
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }

    //7ms   瀵逛簬璁＄畻浜屽弶鏍戞繁搴﹁凯浠ｆ硶娌℃湁閫掑綊娉曞揩
    public boolean isBalanced1(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(getDepth1(root.left) - getDepth1(root.right)) > 1)
            return false;
        boolean leftBa = isBalanced(root.left);
        boolean rightBa = isBalanced(root.right);

        //閫掑綊鍒ゆ柇宸﹀瓙鏍戜笌鍙冲瓙鏍戞槸鍚︽槸骞宠　浜屽弶鏍�
        return leftBa && rightBa;
    }

    //杩唬璁＄畻浜屽弶鏍戞繁搴�
    public int getDepth1(TreeNode root) {
        if(root == null)
            return 0;
        int depth = 0;
        int currentLevelNodes = 1;  //褰撳墠灞傛墍鍖呭惈鐨勮妭鐐规暟
        int nextLevelNodes = 0;     //涓嬩竴灞傛墍鍖呭惈鐨勮妭鐐规暟

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.remove();  //浠庨槦澶寸Щ闄ゅ厓绱�
            currentLevelNodes--;
            if(cur.left != null) {  //濡傛灉鑺傜偣鏈夊乏瀛╁瓙
                queue.add(cur.left);
                nextLevelNodes++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                nextLevelNodes++;
            }

            if(currentLevelNodes == 0) {    //濡傛灉璇ュ眰鐨勬墍鏈夎妭鐐瑰凡缁忛亶鍘嗗畬鎴�
                depth++;
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.right = n3;
        BalancedBinaryTree b = new BalancedBinaryTree();
        System.out.println(b.isBalanced1(n1));
    }
}
