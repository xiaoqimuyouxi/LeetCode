package conclusion.offer;

import java.util.Stack;

/**
 * 面试题21：包含min函数的栈
 * 实现在栈中取得最小元素的时间复杂度是O(1)
 * 调用min,push,pop的时间复杂度都是O(1)
 * Created by ly on 2017/4/22.
 */
public class StackWithMinFunc {
    static Stack<Integer> dataStack = new Stack<>();   //数据栈
    static Stack<Integer> minStack = new Stack<>();    //辅助栈，存放每次push时的最小值
    public static void push(int val) {
        dataStack.push(val);
        //如果辅助栈为空，或者新加入的值比辅助栈栈顶元素小，则把该值push到辅助栈
        if(minStack.size() == 0 || val < minStack.peek()) {
            minStack.push(val);
        }
        else {  //否则若新加入的值比辅助栈栈顶元素大，则把辅助栈栈顶元素再次push到辅助栈
            minStack.push(minStack.peek());
        }
    }

    //弹出栈顶元素
    public static int pop() {
        int temp = 0;
        if(dataStack.size() > 0 && minStack.size() > 0) {
            temp = dataStack.pop();
            minStack.pop();
        }
        return temp;
    }

    //获得当前数据栈中值最小的元素
    public static int min() {
        if(dataStack.size() > 0 && minStack.size() > 0) {
            return minStack.peek();
        }
        else {
            return -1;
        }
    }
}
