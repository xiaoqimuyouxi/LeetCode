package conclusion.offer;

import java.util.Stack;

/**
 * Created by ly on 2017/9/14.
 */
public class P22Stack {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int a = 1, b = 0;
        stack.push(pushA[0]);
        while (!stack.isEmpty() && a <= pushA.length && b < popA.length) {
            int k = stack.peek();
            if(k == popA[b]) {
                stack.pop();
                b++;
            }
            else {
                if(a >= pushA.length) {
                    return false;
                }
                stack.push(pushA[a++]);
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA, popA));
    }
}
