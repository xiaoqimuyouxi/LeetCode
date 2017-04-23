package conclusion.offer;

import java.util.Stack;

/**
 * 面试题22
 * Created by ly on 2017/4/23.
 */
public class StackPushAndPop22 {
    /**
     * 如果下一个要弹出的元素恰好是栈顶数字，那么直接弹出；
     * 如果下一个要弹出的元素不在栈顶，则把压入栈序列中剩余没压入的序列压入辅助栈中，直到出现需要弹出的数字；
     * 如果所有的数字都压入辅助栈中了仍然没有找到要弹出的数字，那么该序列就不是一个弹出序列
     * @param push
     * @param pop
     * @param length
     * @return
     */
    public static boolean isPopOrder(int[] push, int[] pop, int length) {
        boolean possible = false;

        if(push != null && pop != null && length > 0) {
            Stack<Integer> tmpStack = new Stack<>();    //辅助栈

            int pushIndex = 0;
            int popIndex = 0;

            while (popIndex < length) { //弹出序列不到底时

                //如果辅助栈为空，或者栈顶元素不是当前需要弹出的元素
                while (tmpStack.isEmpty() || tmpStack.peek() != pop[popIndex]) {
                    if(pushIndex == length) {   //如果压入栈序列已经全部压入栈，退出循环
                        break;
                    }
                    tmpStack.push(push[pushIndex++]);
                }

                if(tmpStack.peek() != pop[popIndex]) {  //如果辅助栈栈顶元素不是下一个要弹出的元素
                    break;
                }
                //否则是需要弹出的元素，则直接弹出该元素
                tmpStack.pop();
                popIndex++;
            }
            //如果要弹出的辅助栈为空，且弹出序列已经全部处理完，则返回真
            if(tmpStack.isEmpty() && popIndex == length) {
                possible = true;
            }
        }

        return possible;
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,1,2};
        System.out.println(isPopOrder(push, pop, 5));
    }
}
