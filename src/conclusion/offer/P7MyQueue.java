package conclusion.offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列的入队和出队操作
 *
 *
 * 思路：<分析>：
 入队：将元素进栈A
 出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；
 如果不为空，栈B直接出栈。
 * Created by ly on 2017/6/27.
 */
public class P7MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
